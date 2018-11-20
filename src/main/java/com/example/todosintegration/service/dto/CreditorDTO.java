package com.example.todosintegration.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditorDTO implements XmEntityDTO, Serializable {
    private static final long serialVersionUID = 1L;
    // TODO: 20-Nov-18 enum?
    public static final String TYPE_KEY = "CONFIGURATIONS.CREDITOR_LIST";

    private Long creditorId;
    private String creditorCode;
    private String creditorName;
}
