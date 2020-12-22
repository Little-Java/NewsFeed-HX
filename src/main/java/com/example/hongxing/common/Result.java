package com.example.hongxing.common;

public class Result<T> {

    public Result(){

    }

    public Result(Integer statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

    public Result(Integer statusCode, String message, T result){
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

    public Result(Integer statusCode, String message, T result, Integer count){
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
        this.count = count;
    }

    private Integer statusCode;

    private String message;

    private Integer count;

    private T result;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
