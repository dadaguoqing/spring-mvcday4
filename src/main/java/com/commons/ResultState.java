package com.commons;

public enum ResultState {
    FAILURE(502, "请求失败"),
    SUCCESS(200, "请求成功"),

    ERROR(404, "系统错误"),

    INPUT_NAME_OR_PASSWORD(1001, "用户账户或密码输入错误");


    private Integer state;
    private String msg;

    ResultState(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

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
}
