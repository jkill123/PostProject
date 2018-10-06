package com.pinchuk.postproject.command;

import com.pinchuk.postproject.Message;
import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

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
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        logic.update(id, category, sender,receiver,address);
        Message message = logic.search(id);
        if (message == null){
            printer.println("Couldn't find message "+ id);
            return;
        }
        printer.println();
        printer.println("Message updated: ");
        printer.print(message);
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
