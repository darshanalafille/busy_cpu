package com.dfn.controller;

public class Result {

    private Boolean status;
    private Double value;
    private long mills;


    public Result(Boolean status, Double value,long mills) {
        this.status = status;
        this.value = value;
        this.mills = mills;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public long getMills() {
        return mills;
    }

    public void setMills(long mills) {
        this.mills = mills;
    }
}
