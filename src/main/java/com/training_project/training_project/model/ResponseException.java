package com.training_project.training_project.model;

import java.util.Date;

public class ResponseException {
    private String exceptionMessage;
    private String description;
    private Date dateAndTime;


    public ResponseException(String exceptionMessage, String description, Date dateAndTime) {
        this.exceptionMessage = exceptionMessage;
        this.description = description;
        this.dateAndTime = dateAndTime;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    @Override
    public String toString() {
        return "ResponseException{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                ", description='" + description + '\'' +
                ", dateAndTime=" + dateAndTime +
                '}';
    }
}
