package com.example.edulightbe.errors;


import com.example.edulightbe.core.ErrorReport;

import lombok.Getter;

/**
 *
 * @author Le Thanh Long
 */
@Getter
public class EduLightException extends Exception {
    private final ErrorReport report;

    public EduLightException(ErrorReport report) {
        super();
        this.report = report;
    }
}
