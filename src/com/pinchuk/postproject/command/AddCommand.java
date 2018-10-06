package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;
import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

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
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        long id = logic.add(category, sender, address, receiver);
        printer.println();
        printer.println("Added message: ");
        printer.print(logic.search(id));
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
