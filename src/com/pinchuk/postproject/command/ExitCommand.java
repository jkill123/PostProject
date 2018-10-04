package com.pinchuk.postproject.command;

import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public class ExitCommand implements UserCommand{
    @Override
    public void execute(MessageBox messageBox, OutputPrinter printer) {
        printer.println("Exiting....");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "ExitCommand{}";
    }
}
