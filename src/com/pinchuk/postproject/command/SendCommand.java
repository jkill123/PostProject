package com.pinchuk.postproject.command;

import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

import java.util.List;

public class SendCommand implements UserCommand {
    @Override
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        List<Long> longs = logic.sendToMainOffice();
        printer.println();
        printer.println("Message were sent ");
        for (Long id : longs) {
           printer.printAlign("id", id);
        }
        printer.printSeparator();
    }

    @Override
    public String toString() {
        return "SendCommand{}";
    }
}
