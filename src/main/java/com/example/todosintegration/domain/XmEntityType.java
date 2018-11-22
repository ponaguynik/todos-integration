package com.example.todosintegration.domain;

import com.example.todosintegration.domain.dto.*;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nullable;

@Getter
@AllArgsConstructor
public enum XmEntityType {
    CREDITOR("CONFIGURATIONS.CREDITOR_LIST", CreditorDTO.class),
    PROJECT_STATE("CONFIGURATIONS.PROJECT_STATE", ProjectStateDTO.class),
    PROJECT_EVENT_TYPE("CONFIGURATIONS.PROJECT_EVENT_TYPES", ProjectEventTypeDTO.class),
    PROJECT_FIELD("CONFIGURATIONS.PROJECT_FIELD_LIST", ProjectFieldDTO.class),
    RESPONSIBLE_EXECUTOR("CONFIGURATIONS.RESPONSIBLE_EXECUTOR", ResponsibleExecutorDTO.class),
    NEWS("NEWS", NewsDTO.class),
    PROJECT("PROJECTS", ProjectDTO.class);

    private final String typeKey;
    private final Class<? extends XmEntityDTO> dtoClass;

    @Nullable
    @JsonCreator
    public static XmEntityType fromTypeKey(String typeKey) {
        for (XmEntityType xmEntityType : values()) {
            if (xmEntityType.getTypeKey().equals(typeKey)) {
                return xmEntityType;
            }
        }
        return null;
    }

    @JsonValue
    public String getTypeKey() {
        return typeKey;
    }


    @Override
    public String toString() {
        return typeKey;
    }
}
