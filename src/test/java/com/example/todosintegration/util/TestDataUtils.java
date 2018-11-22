package com.example.todosintegration.util;

import com.example.todosintegration.domain.XmEntity;
import com.example.todosintegration.domain.XmEntityType;
import com.example.todosintegration.domain.dto.*;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@UtilityClass
public class TestDataUtils {

    public static XmEntity buildTestXmEntity() {
        return XmEntity.builder()
                .typeKey(XmEntityType.CREDITOR.getTypeKey())
                .id(1L)
                .version(1L)
                .data(TestUtils.toJson(buildTestCreditorDTO()))
                .key("test-key")
                .stateKey("test-state-key")
                .name("test-name")
                .avatarUrl("http://avatars.com/cool-avatar.png")
                .createdBy("Test Dev")
                .description("Some description.")
                .startDate(Date.from(Instant.parse("2007-12-03T10:15:30.00Z")))
                .endDate(Date.from(Instant.parse("2007-12-03T10:18:30.00Z")))
                .updateDate(Date.from(Instant.parse("2007-12-03T10:16:30.00Z")))
                .newEntity(true)
                .removed(false).build();
    }

    public static CreditorDTO buildTestCreditorDTO() {
        return CreditorDTO.builder()
                .creditorId(1L)
                .creditorCode("creditor_code")
                .creditorName("creditor_name").build();
    }

    public static NewsDTO buildTestNewsDTO() {
        return NewsDTO.builder()
                .newsId(1L)
                .newsTitle("Title")
                .newsText("text")
                .lang("ua")
                .newsDate("21-Nov-18")
                .attachments(Arrays.asList(
                        DocAttachmentDTO.builder()
                                .docId(1L)
                                .docName("doc name")
                                .fileName("file name")
                                .fileSize("10M").build(),
                        DocAttachmentDTO.builder()
                                .docId(2L)
                                .docName("doc name 1")
                                .fileName("file name 1")
                                .fileSize("15M").build()
                )).build();
    }

    public static ProjectEventTypeDTO buildTestProjectEventTypeDTO() {
        return ProjectEventTypeDTO.builder()
                .eventTypeCode("type_code")
                .eventTypeNameEng("type name")
                .eventTypeNameUkr("назвва типу")
                .build();
    }

    public static ProjectFieldDTO buildTestProjectFieldDTO() {
        return ProjectFieldDTO.builder()
                .fieldId(1L)
                .fieldNameEng("field name")
                .fieldNameUkr("назва")
                .build();
    }

    public static ProjectStateDTO buildTestProjectStateDTO() {
        return ProjectStateDTO.builder()
                .stateId(1L)
                .stateNameEng("state_name")
                .stateNameUkr("стан проекту").build();
    }

    public static ResponsibleExecutorDTO buildTestResponsibleExecutorDTO() {
        return ResponsibleExecutorDTO.builder()
                .responsibleExecutorId(1L)
                .responsibleExecutorNameEng("name")
                .responsibleExecutorNameUkr("назва")
                .build();
    }

    public static ProjectDTO buildTestProjectDTO() {
        return ProjectDTO.builder()
                .projectId(1L)
                .projectName("project name")
                .projectStateId(1L)
                .projectStateName("state name")
                .projectFieldId(1L)
                .projectFieldName("field name")
                .projectPurpose("project purpose")
                .creditor(1L)
                .creditName("creditor name")
                .initiator("initiator")
                .beneficiar("beneficiar")
                .projectBeginDate("2007-12-04T10:12:30.00Z")
                .projectEndDate("2007-12-05T10:12:30.00Z")
                .creditSum(20.12d)
                .creditCur("credit cur")
                .creditNum("credit num")
                .creditDateBegin("2007-12-03T10:16:30.00Z")
                .creditName("credit name")
                .finConditions("fin conditions")
                .creditDateEnd("2007-12-03T10:18:30.00Z")
                .fundsAvailableBegin("2007-12-03T10:16:30.00Z")
                .fundsAvailableEnd("2007-12-05T10:16:30.00Z")
                .responsibleExecutorId(1L)
                .responsibleExecutorName("responsible executor name")
                .lang("ua")
                .isArchived(true)
                .docAttachments(Arrays.asList(
                        DocAttachmentDTO.builder()
                                .docId(1L)
                                .docName("doc name")
                                .fileName("file name")
                                .fileSize("10M").build(),
                        DocAttachmentDTO.builder()
                                .docId(2L)
                                .docName("doc name 1")
                                .fileName("file name 1")
                                .fileSize("15M").build()
                ))
                .projectEvents(Arrays.asList(
                        ProjectEventDTO.builder()
                                .eventCode("event_code")
                                .eventDesc("event description")
                                .build(),
                        ProjectEventDTO.builder()
                                .eventCode("event_code1")
                                .eventDesc("event description 1")
                                .build()
                ))
                .build();
    }
}
