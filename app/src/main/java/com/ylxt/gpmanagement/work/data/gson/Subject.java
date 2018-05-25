package com.ylxt.gpmanagement.work.data.gson;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/21.
 */

public class Subject {
    public int status;
    public String msg;
    public List<SubjectData> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SubjectData> getData() {
        return data;
    }

    public void setData(List<SubjectData> data) {
        this.data = data;
    }
}
