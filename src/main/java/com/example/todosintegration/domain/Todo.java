package com.example.todosintegration.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "todo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo implements Serializable {
    private static final long serialVersionUID = 1L;

    // Ids are provided by service (XM)
    @Id
    private Long code;
    @Column(name = "user_code")
    private Long userCode;
    @Column(name = "title")
    private String title;
    @Column(name = "completed")
    private boolean completed;
}
