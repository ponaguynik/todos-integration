package com.example.todosintegration.web.rest;

import com.example.todosintegration.TodosIntegrationApplication;
import com.example.todosintegration.domain.Todo;
import com.example.todosintegration.repository.TodoRepository;
import com.example.todosintegration.service.mapper.TodoMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TodosIntegrationApplication.class)
public class TodoResourceTest {
    public static final Long DEFAULT_CODE = 12345L;
    public static final Long DEFAULT_USER_CODE = 54321L;
    public static final String DEFAULT_TITLE = "Test Title";
    public static final boolean DEFAULT_COMPLETED = false;
    public static final String DEFAULT_XM_TODO_URL = "http://localhost:8080/api/xm-todos";

    @Autowired
    private TodoResource todoResource;

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @MockBean
    private RestTemplate restTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private MockMvc todoMockMvc;

    private Todo todo;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.todoMockMvc = MockMvcBuilders.standaloneSetup(todoResource)
                .setMessageConverters(jacksonMessageConverter).build();
    }

    @Before
    public void initTest() {
        todo = createTodo(DEFAULT_CODE, DEFAULT_USER_CODE, DEFAULT_TITLE, DEFAULT_COMPLETED);
    }

    private Todo createTodo(Long code, Long userCode, String title, boolean completed) {
        return Todo.builder()
                .code(code)
                .userCode(userCode)
                .title(title)
                .completed(completed).build();
    }

    @Test
    @Transactional
    public void getAllTodos() throws Exception {
        todoRepository.saveAndFlush(todo);

        todoMockMvc.perform(get("/api/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(objectMapper.writeValueAsString(asArray(todo))));
    }

    @Test
    @Transactional
    public void getTodo() throws Exception {
        todoRepository.saveAndFlush(todo);

        todoMockMvc.perform(get("/api/todos/{code}", DEFAULT_CODE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(objectMapper.writeValueAsString(todo)));
    }

    @Test
    @Transactional
    public void getAllTodosByUserCode() throws Exception {
        todoRepository.saveAndFlush(todo);
        todoRepository.saveAndFlush(createTodo(2345L, 5432L, "Another Title", false));

        todoMockMvc.perform(get("/api/todos")
                    .param("userCode", String.valueOf(DEFAULT_USER_CODE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(content().json(objectMapper.writeValueAsString(asArray(todo))));
    }

    @Test
    @Transactional
    public void loadTodosByUrl() throws Exception {
        doReturn(ResponseEntity.ok(Collections.singletonList(todoMapper.toXmTodo(todo))))
                .when(restTemplate).exchange(eq(DEFAULT_XM_TODO_URL), eq(HttpMethod.GET), nullable(HttpEntity.class),
                    any(ParameterizedTypeReference.class));

        todoMockMvc.perform(post("/api/todos")
                    .param("url", DEFAULT_XM_TODO_URL))
                .andExpect(status().isOk());

        Todo dbTodo = todoRepository.findByCode(this.todo.getCode()).orElseGet(() -> {
            fail();
            return null;
        });
        assertEquals(todo, dbTodo);
    }

    @SafeVarargs
    private static <T> T[] asArray(T... o) {
        return o;
    }
}