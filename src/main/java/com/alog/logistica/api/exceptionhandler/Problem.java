package com.alog.logistica.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Problem {

    private Integer status;
    private LocalDateTime dateTime;
    private String title;

    @AllArgsConstructor
    @Getter
    public static class Fields {

        private String field;
        private String message;


    }
}
