package com.rms.api.model.instantCash;

import lombok.Data;

import java.util.List;

@Data
public class ICConfirmErrorDTO {

    private String code;
    private String message;
    private List<ICConfirmErrorDetailsDTO> details;
}
