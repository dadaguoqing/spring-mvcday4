package com.commons;

import org.springframework.context.annotation.Configuration;

import java.io.Serializable;

/**
 * Class: Result
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/16 10:38
 * Version: V1.0
 */
@Configuration
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7372018318253228614L;

    public Result() {
        setResultState(ResultState.SUCCESS);
    }

    public void setResultState(ResultState resultState) {
        this.state = resultState.getState();
        this.msg = resultState.getMsg();
    }

    private Integer state;
    private String msg;
    private T data;

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
