package com.example.todosintegration.service.mapper;

import com.example.todosintegration.domain.Todo;
import com.example.todosintegration.domain.XmTodo;
import com.example.todosintegration.service.dto.TodoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TodoMapper {

    @Mappings({
            @Mapping(target = "code", source = "id"),
            @Mapping(target = "userCode", source = "userId")
    })
    Todo fromXmTodo(XmTodo xmTodo);

    @Mappings({
            @Mapping(target = "id", source = "code"),
            @Mapping(target = "userId", source = "userCode")
    })
    XmTodo toXmTodo(Todo todo);

    Todo fromTodoDTO(TodoDTO todoDTO);

    TodoDTO toTodoDTO(Todo todo);
}
