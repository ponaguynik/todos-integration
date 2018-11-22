package com.example.todosintegration.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO implements XmEntityDTO, Serializable {
    private static final long serialVersionUID = 1L;

    private Long newsId;
    private String newsTitle;
    private String newsText;
    private String lang;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String newsDate;
    private List<DocAttachmentDTO> attachments = new ArrayList<>();
}
