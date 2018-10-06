package com.pinchuk.postproject.command;

import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

public class ExitCommand implements UserCommand{
    @Override
    public void execute(PostBusinessLogic logic, OutputPrinter printer) {
        printer.println("Exiting....");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "ExitCommand{}";
    }
}
