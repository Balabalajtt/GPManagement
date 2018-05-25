package com.ylxt.gpmanagement.work.data.gson;

import java.util.List;

/**
 * Created by 江婷婷 on 2018/5/24.
 */

public class Shengbao {
    public int status;
    public String msg;
    public SubjectData data;

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

    public SubjectData getData() {
        return data;
    }

    public void setData(SubjectData data) {
        this.data = data;
    }
}
