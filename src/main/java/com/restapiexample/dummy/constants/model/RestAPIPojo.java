package com.restapiexample.dummy.constants.model;

import java.util.HashMap;

public class RestAPIPojo {

    private String status;
    private HashMap<String,Object> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, ?> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
