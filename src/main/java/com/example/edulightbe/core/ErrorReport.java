package com.example.edulightbe.core;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorReport<T> {
    private String message;
    private T data;
}
