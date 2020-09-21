package com.dts.rentgameapi.domain.response.base;

/**
 * Created by ducnv521 on 4/4/1018.
 */
public class BaseResponse {
    protected String message;

    protected int code;

    public BaseResponse() {
        this.code = -1;
        this.message = "Unknown";
    }

    public BaseResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }


    public void setSuccess() {
        this.code = 200;
        this.message = "OK";
    }

    public void setFailed() {
        this.setFailed("Failed");
    }

    public void setFailed(String msg) {
        this.code = 400;
        this.message = msg;
    }

    public void setItemNotFound(String message) {
        this.code = 400;
        this.message = message;
    }

    public void setItemNotFound() {
        setItemNotFound("item not found");
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
