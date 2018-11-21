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
                        NewsDTO.DocAttachmentDTO.builder()
                                .docId(1L)
                                .docName("doc name")
                                .fileName("file name")
                                .fileSize("10M").build(),
                        NewsDTO.DocAttachmentDTO.builder()
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
}
