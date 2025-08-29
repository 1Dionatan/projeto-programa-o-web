package com.projeto.dionatan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TurmaBadRequestException extends RuntimeException {
    public TurmaBadRequestException(String msg) {
        super(msg);
    }
}
