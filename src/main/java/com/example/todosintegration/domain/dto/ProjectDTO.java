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
public class ProjectDTO implements XmEntityDTO, Serializable {
    private static final long serialVersionUID = 1L;

    private Long projectId;
    private String projectName;
    private Long projectStateId;
    private String projectStateName;
    private Long projectFieldId;
    private String projectFieldName;
    private String projectPurpose;
    private Long creditor;
    private String creditorName;
    private String initiator;
    private String beneficiar;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String projectBeginDate;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String projectEndDate;
    private Long creditSum;
    private String creditCur;
    private String creditNum;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String creditDateBegin;
    private String creditName;
    private String finConditions;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String creditDateEnd;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String fundsAvailableBegin;
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private String fundsAvailableEnd;
    private Long responsibleExecutorId;
    private String responsibleExecutorName;
    private String lang;
    private Boolean isArchived;
    private List<DocAttachmentDTO> attachments = new ArrayList<>();
    private List<ProjectEventDTO> event = new ArrayList<>();
}
