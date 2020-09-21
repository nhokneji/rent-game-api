package com.dts.rentgameapi.domain.response.base;

/**
 * @author Rin-DTS
 */
public class SingleItemResponse<T> extends BaseResponse {
    private T item;

    public SingleItemResponse(T item) {
        this.item = item;
    }

    public SingleItemResponse() {
    }

    public SingleItemResponse(String message, int code, T item) {
        super(message, code);
        this.item = item;
    }

    public void setSuccess(T item) {
        super.setSuccess();
        this.item = item;
    }

    public void setResult(T item, String msgError) {
        if (item == null) {
            super.setItemNotFound(msgError);
        } else {
            setSuccess(item);
        }
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "SingleItemResponse{" +
                "item=" + item +
                ", message='" + message + '\'' +
                ", code=" + code +
                '}';
    }
}
