package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;
import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public class AddCommand implements UserCommand{
    private String sender;
    private String receiver;
    private String address;
    private Message.MessageCategory category;

    public AddCommand(String sender, String receiver, String address, Message.MessageCategory category) {
        this.sender = sender;
        this.receiver = receiver;
        this.address = address;
        this.category = category;
    }

    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {
        long id = messageBox.add(category, sender, address, receiver);
        printer.println("Added message: id = "+ id);
        printer.printSeparator();
    }

    @Override
    public String toString() {
        return "AddCommand{" +
                "sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", address='" + address + '\'' +
                ", category=" + category +
                '}';
    }
}
