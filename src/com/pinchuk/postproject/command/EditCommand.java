package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;

public class EditCommand implements  UserCommand {
    private long id;
    private String sender;
    private String reciever;
    private String address;
    private Message.MessageCategory category;

    public EditCommand(long id) {
        this.id = id;

}

    public long getId() {
        return id;
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
