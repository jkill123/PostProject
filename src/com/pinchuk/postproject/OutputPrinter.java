package com.pinchuk.postproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class OutputPrinter {
    private static final Logger log = LoggerFactory.getLogger(OutputPrinter.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private PrintStream outStream;
    private Properties strings;

    public OutputPrinter(PrintStream outStream){
        this.outStream = outStream;
        strings = new Properties();//создаю пустой набор свойств
        try(InputStream stream=getClass().getClassLoader().getResourceAsStream("strings.prop")){
            strings.load(stream);//достать файл с ресурсов и интерпритировать его как стрим,
        } catch (IOException e) {
            log.error("Error loading strings file", e);
        }
    }
    public void printSeparator(){
        outStream.println("---------------------------");
        outStream.println();
    }


    public void println(String s) {
        outStream.println(s);
    }
    public void print(String s) {
        outStream.print(s);
    }

    public void printf(String format, Object... args){
        outStream.printf(format, args);
    }

    public void printUserPromt(){
        outStream.print(">> ");
    }

    public void print(Message message){
        printAlign(strings.getProperty("message.id"), message.getId());
        printAlign("Category",message.getCategory());
        printAlign("From ",message.getSender());
        printAlign("To",message.getReceiver());
        printAlign("Address",message.getAddress());
        printAlign("Date",dateFormat.format(message.getDate()));
    }

    public void printAlign(String caption, String data){
        outStream.printf("%10s: %s%n", caption, data);
    }

    public void printAlign(String caption, Object data){
        printAlign(caption, data.toString());
    }

    public void println() {
        printf("%n");
    }

    public void printSmallSeparator() {
        outStream.println("-----");
    }



    public void printHelp(UserCommandLineCommand command) {

        String fullName = command.getName();
        for (UserCommandLineCommand.Parameter parameter : command.getParameters()) {
            fullName+= "["+parameter.getName()+"]";
        }
        outStream.printf("%10s - %s%n",fullName, command.getDescription());
        for (UserCommandLineCommand.Parameter parameter : command.getParameters()) {
            outStream.printf("%20s: %s%n", parameter.getName(), parameter.getDescription());

        }
    }

    public void printHelp() {
        printSeparator();
        printHelp(new UserCommandLineCommand("add", "Adds new message to message box"));
        printHelp(new UserCommandLineCommand("edit", "Edit message", new UserCommandLineCommand.Parameter("id", "message identification")));
        printHelp(new UserCommandLineCommand("remove", "Remove message", new UserCommandLineCommand.Parameter("id", "message identification")));
        printHelp(new UserCommandLineCommand("send", "Sends all messages to the  main office"));
        printHelp(new UserCommandLineCommand("list", "Show all messages from message box"));
        printHelp(new UserCommandLineCommand("help", "Show this help"));
        printHelp(new UserCommandLineCommand("exit", "Exit"));
        println();
        printSeparator();
    }

}
