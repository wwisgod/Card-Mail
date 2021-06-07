package com.qf.ww.entity;

import java.util.List;

public class Message {
    private String respMessage;
    private int id;
    private String name;
    private List<?> list;

    public Message() {
    }

    public Message(List<?> list) {
        this.list = list;
    }

    public Message(String respMessage) {
        this.respMessage = respMessage;
    }

    public Message(String respMessage, int id, String name) {
        this.respMessage = respMessage;
        this.id = id;
        this.name = name;
    }

    public Message(String respMessage, int id, String name, List<?> list) {
        this.respMessage = respMessage;
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public String getRespMessage() {
        return respMessage;
    }

    public void setRespMessage(String respMessage) {
        this.respMessage = respMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Message{" +
                "respMessage='" + respMessage + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
