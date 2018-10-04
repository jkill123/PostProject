package com.pinchuk.postproject.command;

import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

import java.util.List;

public class SendCommand implements UserCommand {
    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {
        List<Long> longs = messageBox.sendToMianOffice();
        printer.println("Message were sent " + longs);
        printer.printSeparator();

    }

    @Override
    public String toString() {
        return "SendCommand{}";
    }
}
