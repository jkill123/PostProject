package com.pinchuk.postproject;

import java.util.Date;

public class Message {
    public enum MessageCategory{
        REGULAR, SPECIAL, FIRST_CLASS
    }
    private MessageCategory category;
    private String sender;
    private String address;
    private String receiver;
    private long id;
    private Date date;

    public Message(MessageCategory category, String sender, String address, String receiver) {
        this.category = category;
        this.sender = sender;
        this.address = address;
        this.receiver = receiver;
        this.date = new Date();
    }

    public Message(long id, MessageCategory category, String sender, String address, String receiver,  Date date) {
        this(category,sender,address,receiver);
        this.id = id;
        this.date = date;
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

    public String getAddress() {
        return address;
    }

    public void setAddres(String address) {
        this.address = address;
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
                ", address='" + address + '\'' +
                ", receiver='" + receiver + '\'' +
                ", id=" + id +
                ", date=" + date +
                '}';
    }
}
