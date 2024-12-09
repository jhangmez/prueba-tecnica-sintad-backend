package com.sintad_jhan.api.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldErrorDTO {
    private String field;
    private String defaultMessage;
}
