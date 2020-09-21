package com.dts.rentgameapi.domain.response.base;

import java.util.ArrayList;
import java.util.List;

public class GetListResponse<T> extends BaseResponse {
    private long total;
    private List<T> datas;

    public GetListResponse() {
        super();
        this.total = 0;
        this.datas = new ArrayList<>();
    }

    public GetListResponse(Integer total, List<T> datas, String message, int code) {
        super(message, code);
        this.total = total;
        this.datas = datas;
    }


    public void setSuccess(List<T> datas, long total) {
        super.setSuccess();
        this.datas = datas;
        this.total = total;
    }

    public void setResult(List<T> datas, long total) {
        setResult(datas, total, "items not found");
    }

    public void setResult(List<T> datas, long total, String msgNotfound) {
        if (datas != null && !datas.isEmpty()) {
            super.setSuccess();
            this.datas = datas;
            this.total = total;
        } else {
            super.setItemNotFound(msgNotfound);
        }
    }


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "GetListResponse{" +
                "total=" + total +
                ", datas=" + datas +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
