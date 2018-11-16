package com.example.todosintegration.web.rest;

import com.example.todosintegration.service.TodoService;
import com.example.todosintegration.service.dto.TodoDTO;
import com.example.todosintegration.util.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@Slf4j
public class TodoResource {
    private final TodoService todoService;

    @Autowired
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<TodoDTO> getAllTodos() {
        log.debug("REST request to get all Orders");
        return todoService.getAll();
    }

    @GetMapping("/{code}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable Long code) {
        log.debug("REST request to get Todo by code : {}", code);
        return ResponseUtils.wrapOrNotFound(todoService.findByCode(code));
    }

    @GetMapping(params = "userCode")
    public List<TodoDTO> getAllTodosByUserCode(@RequestParam("userCode") Long userCode) {
        log.debug("REST request to get all Orders by userCode : {}", userCode);
        return todoService.findAllByUserCode(userCode);
    }

    @PostMapping(params = "url")
    public void loadTodosByUrl(@RequestParam("url") String url) {
        log.debug("REST request to load Todos by url : {}", url);
        todoService.loadByUrl(url);
    }
}
