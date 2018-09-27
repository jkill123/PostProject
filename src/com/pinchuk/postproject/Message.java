package com.pinchuk.postproject;

import java.util.Date;

public class Message {
    public enum MessageCategory{
        REGULAR, SPECIAL, FIRST_CLASS
    }
    private MessageCategory category;
    private String sender;
    private String addres;
    private String receiver;
    private long id;
    private Date date;

    public Message(MessageCategory category, String sender, String addres, String receiver) {
        this.category = category;
        this.sender = sender;
        this.addres = addres;
        this.receiver = receiver;
        this.date = new Date();
    }

    public MessageCategory getCategory() {
        return category;
    }

    public void setCategory(MessageCategory category) {
        this.category = category;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Message{" +
                "category=" + category +
                ", sender='" + sender + '\'' +
                ", addres='" + addres + '\'' +
                ", receiver='" + receiver + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
