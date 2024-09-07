package org.example.taskservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.net.URI;


@ControllerAdvice
public class
GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ProblemDetail handleAllExceptions(Exception ex, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        problemDetail.setTitle("An error occurred");
        problemDetail.setDetail(ex.getMessage());
        problemDetail.setInstance(
                URI.create(request.getDescription(false).replace("uri=", "")));
        return problemDetail;
    }

}