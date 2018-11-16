package com.example.todosintegration.service;

import com.example.todosintegration.client.XmTodoClient;
import com.example.todosintegration.client.exception.UnableLoadXmTodoException;
import com.example.todosintegration.domain.XmTodo;
import com.example.todosintegration.repository.TodoRepository;
import com.example.todosintegration.service.dto.TodoDTO;
import com.example.todosintegration.service.mapper.TodoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;
    private final XmTodoClient xmTodoClient;

    @Autowired
    public TodoService(TodoRepository todoRepository,
                       TodoMapper todoMapper,
                       XmTodoClient xmTodoClient) {
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
        this.xmTodoClient = xmTodoClient;
    }

    // TODO: 16-Nov-18 consider pagination
    @Transactional(readOnly = true)
    public List<TodoDTO> getAll() {
        return todoRepository.streamAll()
                .map(todoMapper::toTodoDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<TodoDTO> findByCode(Long code) {
        return todoRepository.findByCode(code)
                .map(todoMapper::toTodoDTO);
    }

    @Transactional(readOnly = true)
    public List<TodoDTO> findAllByUserCode(Long userCode) {
        return todoRepository.streamAllByUserCode(userCode)
                .map(todoMapper::toTodoDTO)
                .collect(Collectors.toList());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void loadByUrl(String url) {
        loadFromClientByUrl(url).stream()
                .map(todoMapper::fromXmTodo)
                .forEach(todoRepository::save);
    }

    private List<XmTodo> loadFromClientByUrl(String url) {
        try {
            return xmTodoClient.loadAllByUrl(url);
        } catch (Exception e) {
            String msg = "Failed to load Todos by url : " + url + ". Cause : " + e.getMessage();
            log.error(msg);
            throw new UnableLoadXmTodoException(msg, e);
        }

    }
}
