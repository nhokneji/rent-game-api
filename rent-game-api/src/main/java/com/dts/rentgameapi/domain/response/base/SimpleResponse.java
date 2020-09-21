package com.dts.rentgameapi.domain.response.base;

/**
 * @author Rin-DTS
 */
public class SimpleResponse extends BaseResponse {
    private Boolean result;

    public SimpleResponse(Boolean result) {
        this.result = result;
    }

    public SimpleResponse() {
    }

    public SimpleResponse(String message, int code, Boolean result) {
        super(message, code);
        this.result = result;
    }

    public void setSuccess(Boolean result) {
        super.setSuccess();
        this.result = result;
    }

    public void setResult(Boolean result, String msgError) {
        if (result)
            super.setSuccess();
        else
            super.setFailed(msgError);
        this.result = result;
    }

    @Override
    public String toString() {
        return "SimpleResponse{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
