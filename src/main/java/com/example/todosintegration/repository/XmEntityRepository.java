package com.example.todosintegration.repository;

import com.example.todosintegration.domain.XmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface XmEntityRepository extends JpaRepository<XmEntity, Long> {

    List<XmEntity> findAllByTypeKey(String typeKey);
}
