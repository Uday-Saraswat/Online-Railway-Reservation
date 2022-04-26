package com.casestudy.uday.CustomException;

public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private String ErrCode;
    private String ErrMess;
    public String getErrCode() {
        return ErrCode;
    }
    public void setErrCode(String errCode) {
        this.ErrCode = errCode;
    }
    public String getErrMess() {
        return ErrMess;
    }
    public void setErrMess(String errMess) {
        this.ErrMess = errMess;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public CustomException(String errCode, String errMess) {
        super();
        this.ErrCode = errCode;
        this.ErrMess = errMess;
    }
    @Override
    public String toString() {
        return "Custom  Exception [ErrCode=" + ErrCode + ", ErrMess=" + ErrMess + "]";
    }

    public CustomException() {}


}

