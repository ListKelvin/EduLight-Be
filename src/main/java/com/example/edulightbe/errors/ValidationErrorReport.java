package com.example.edulightbe.errors;

import com.example.edulightbe.core.ErrorReport;


import java.util.List;

public class ValidationErrorReport extends ErrorReport<List<ValidationError>> {
    public ValidationErrorReport(List<ValidationError> data) {
        super("Validation error", data);
    }
}
