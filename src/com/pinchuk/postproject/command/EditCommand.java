package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;
import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public class EditCommand implements  UserCommand {
    private long id;
    private String sender;
    private String receiver;
    private String address;
    private Message.MessageCategory category;

    public EditCommand(long id) {
        this.id = id;

}
    public long getId() {
        return id;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCategory(Message.MessageCategory category) {
        this.category = category;
    }

    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {
        Message message = messageBox.search(id);
        if (message == null){
            printer.println("Couldn't find message "+ id);
            return;
        }
        message.setCategory(category);
        message.setSender(sender);
        message.setReceiver(receiver);
        message.setAddres(address);
        printer.println("Message updated: "+ message);
        printer.printSeparator();
    }

    @Override
    public String toString() {
        return "EditCommand{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", address='" + address + '\'' +
                ", category=" + category +
                '}';
    }
}
