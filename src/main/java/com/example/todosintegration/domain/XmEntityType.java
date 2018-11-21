package com.example.todosintegration.domain;

import com.example.todosintegration.domain.dto.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nullable;

@Getter
@AllArgsConstructor
public enum XmEntityType {
    CREDITOR("CONFIGURATIONS.CREDITOR_LIST", CreditorDTO.class),
    PROJECT_STATE("CONFIGURATIONS.PROJECT_STATE", ProjectStateDTO.class),
    PROJECT_EVENT_TYPE("CONFIGURATIONS.PROJECT_EVENT_TYPES", ProjectEventTypeDTO.class),
    PROJECT_FIELD("CONFIGURATIONS.PROJECT_FIELD_LIST", ProjectFieldDTO.class);

    private final String typeKey;
    private final Class<? extends XmEntityDTO> dtoClass;

    @Nullable
    public static XmEntityType fromTypeKey(String typeKey) {
        for (XmEntityType xmEntityType : values()) {
            if (xmEntityType.getTypeKey().equals(typeKey)) {
                return xmEntityType;
            }
        }
        return null;
    }
}
