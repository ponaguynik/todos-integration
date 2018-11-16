package com.example.todosintegration.repository;

import com.example.todosintegration.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findByCode(Long code);

    @Query(value = "select t from Todo t")
    Stream<Todo> streamAll();

    Stream<Todo> streamAllByUserCode(Long userCode);
}
