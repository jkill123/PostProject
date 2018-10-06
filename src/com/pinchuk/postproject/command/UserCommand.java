package com.pinchuk.postproject.command;

import com.pinchuk.postproject.OutputPrinter;
import com.pinchuk.postproject.PostBusinessLogic;

public interface UserCommand {
    void execute(PostBusinessLogic logic, OutputPrinter printer);
}
