package com.pinchuk.postproject;

import com.pinchuk.postproject.command.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class UserConsoleInputReader {
    private Scanner scanner;
    private OutputPrinter printer;

    public UserConsoleInputReader(OutputPrinter printer) {
        this.printer = printer;
        scanner = new Scanner(System.in);
    }
    public UserCommand nextCommand(){
        Scanner s= new Scanner(scanner.nextLine());
        if (s.hasNext()) {
            String token = s.next();
            if (token.equalsIgnoreCase("remove")) {
                return parseRemove(s);
            } else if (token.equalsIgnoreCase("edit")) {
                return parseEdit(s);
            } else if (token.equalsIgnoreCase("add")) {
                return parseAdd(s);
            } else if (token.equalsIgnoreCase("send")) {
                if (!s.hasNext()) {
                    return new SendCommand();
                }
            } else if (token.equalsIgnoreCase("list")) {
                if (!s.hasNext()) {
                    return new ListCommand();
                }
            } else if (token.equalsIgnoreCase("help")) {
                if (!s.hasNext()) {
                    return new HelpCommand();
                }
            } else if (token.equalsIgnoreCase("exit")) {
                if (!s.hasNext()) {
                    return new ExitCommand();
                }
            }
        }else {
            return new EmptyCommand();
        }
        return null;
    }

    private AddCommand parseAdd(Scanner s) {
        if(s.hasNext() ) {
            return null;
        }
            printer.println("Plz, enter sender: ");
            printer.printUserPromt();
            String sender = scanner.nextLine();
            printer.println("Plz enter receiver: ");
            printer.printUserPromt();
            String receiver = scanner.nextLine();
            printer.println("Plz enter address: ");
            printer.printUserPromt();
            String address = scanner.nextLine();
            printer.println("Plz enter category from "+ Arrays.toString(Message.MessageCategory.values()));
            printer.printUserPromt();
            Message.MessageCategory cat = readCategory();
            return new AddCommand(sender, receiver, address, cat);
    }

    private Message.MessageCategory readCategory() {
        Message.MessageCategory cat;
        while (true) {
            String category = scanner.nextLine().trim();
            cat = convertToCategory(category);
           if (cat !=null) {
               break;
           }else {
               printer.println("Plz enter category from "+ Arrays.toString(Message.MessageCategory.values()));
               printer.printUserPromt();
           }
        }
        return cat;
    }

    private Message.MessageCategory convertToCategory(String category) {
        switch (category){
            case "first_class":
                return Message.MessageCategory.FIRST_CLASS;
            case "special":
                return Message.MessageCategory.SPECIAL;
            case "regular":
                return Message.MessageCategory.REGULAR;
            default:
                return null;
        }
    }

    private EditCommand parseEdit(Scanner s) {
        if (s.hasNextLong()) {
            long l = s.nextLong();
            if (!s.hasNext()) {
                return new EditCommand(l);
            }
        }
        return null;
    }

    private RemoveCommand parseRemove(Scanner s) {
        if (s.hasNextLong()) {
            long l = s.nextLong();
            if (!s.hasNext()) {
                return new RemoveCommand(l);
            }
        }
        return null;
    }

    public void readEdit(EditCommand command,String sender, String receiver, String address, Message.MessageCategory category) {

        printer.print("Change sender ("+ sender+"): if you want");
        command.setSender(readOrSkip(sender));

        printer.print("Change receiver ("+ receiver +"): if you want");
        command.setReceiver(readOrSkip(receiver));

        printer.print("Change address ("+ address+"): if you want");
        command.setAddress(readOrSkip(address));

        printer.print("Change category ("+ category +"): if you want");
        command.setCategory(readOrSkip(category, this::convertToCategory, category1 -> category1 != null)); //сылка на метод(лямбда)

    }
    private String readOrSkip(String previous){
        return readOrSkip(previous, t -> t, t-> true); // лямбда выражение
    }

    private <T> T readOrSkip(T previous, Function<String, T> convert, Function<T, Boolean> validate){
        String line = scanner.nextLine().trim();
        if(!line.isEmpty()){
            T result = convert.apply(line);
            if (validate.apply(result)){
                return result;
            }else {
                printer.println("Wrong value , plz repeat");
                printer.printUserPromt();
            }
        }
        return previous;
    } // дженерики , конвертация строки пользователя.
     // принимаю MessageCategory, считываю строку , и если на входе строка то конвертирует
}


