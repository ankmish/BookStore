package com.assignment.readingisgood.models;


public abstract class Response {
    Integer statusResponse;
    String description;
    public Response(Integer statusResponse,String description){
        this.statusResponse = statusResponse;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Response{" +
                "statusResponse=" + statusResponse +
                ", description='" + description + '\'' +
                '}';
    }
}