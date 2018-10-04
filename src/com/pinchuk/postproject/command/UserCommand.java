package com.pinchuk.postproject.command;

import com.pinchuk.postproject.MessageBox;
import com.pinchuk.postproject.OutputPrinter;

public interface UserCommand {
    void execute(MessageBox messageBox, OutputPrinter printer);
}
