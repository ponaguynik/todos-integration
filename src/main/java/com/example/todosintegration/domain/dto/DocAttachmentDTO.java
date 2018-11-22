package com.example.todosintegration.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocAttachmentDTO implements Serializable {
    private Long docId;
    private String fileName;
    private String docName;
    private String fileSize;
}
