package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;

public class AddCommand implements UserCommand{
    private String sender;
    private String reciever;
    private String address;
    private Message.MessageCategory category;

    public AddCommand(String sender, String reciever, String address, Message.MessageCategory category) {
        this.sender = sender;
        this.reciever = reciever;
        this.address = address;
        this.category = category;
    }

    public String getSender() {
        return sender;
    }

    public String getReciever() {
        return reciever;
    }

    public String getAddress() {
        return address;
    }

    public Message.MessageCategory getCategory() {
        return category;
    }
}
