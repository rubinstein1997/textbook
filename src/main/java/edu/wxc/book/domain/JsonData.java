package edu.wxc.book.domain;

public class JsonData {
    int statu;

    Object data;

    String msg;

    public JsonData(int statu, Object data, String msg) {
        this.statu = statu;
        this.data = data;
        this.msg = msg;
    }

    public int getStatu() {
        return statu;
    }

    public void setStatu(int statu) {
        this.statu = statu;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JsonData{" +
                "statu=" + statu +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
