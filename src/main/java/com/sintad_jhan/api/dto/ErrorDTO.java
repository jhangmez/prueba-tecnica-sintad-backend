package com.sintad_jhan.api.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ErrorDTO {
    private String message;
    private List<FieldErrorDTO> fieldErrors;

    public ErrorDTO(String message) {
        this.message = message;
    }
    public ErrorDTO(String message, List<FieldErrorDTO> fieldErrors) {
        this.message = message;
        this.fieldErrors = fieldErrors;
    }
}
