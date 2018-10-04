package com.pinchuk.postproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class MessageBox {
    private static final Logger log = LoggerFactory.getLogger(MessageBox.class);
    private MainOffice mainoffice;
    private List<Message> messages;
    private static long nextIndex =0;



    public MessageBox() {
        this(100);
    }


    public MessageBox(int count) {
        log.debug("Create message box with initial size = " + count);
        messages = new ArrayList<>(count);
        mainoffice = new MainOffice();
    }


    public long add(Message.MessageCategory category, String sender, String address, String receiver){
        log.debug(String.format("category = %s, from%s, to%s(%s)", category, sender, receiver, address));
       Message message = new Message(category, sender, address,receiver);
       message.setId(nextIndex++);
       messages.add(message);
       return message.getId();
    }

    public Message search(long id){
        for (Message message : messages) {
            if (message.getId() == id){
                return message;
            }
        }
        return null;
    } // изменение данных письма

    public boolean delete(long id ) {
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()){
            Message next = iterator.next();
            if(next.getId() == id ) {
                log.debug(String.format("Delete message: %d", id));
                iterator.remove();
                return  true;
            }
        }
        log.debug(String.format("Couldn't delete message: %d", id));
        return false;
    } //удаление письма

    public List<Long> sendToMianOffice(){
        log.debug("Send message to main office.");
        List<Long> ids =new ArrayList<>();
        Iterator<Message> iterator = messages.iterator();
        while (iterator.hasNext()){
            Message next = iterator.next();
            boolean accepted = mainoffice.queue(next);
            if(accepted){
                ids.add(next.getId()); // Добавить в список индентификаторов который отправили
                iterator.remove();
            }
        }


        return ids;

    }

    public List<Message> list(){
        return new ArrayList<>(messages);
    }

    @Override
    public String toString() {
        return "MessageBox{" +
                "messages=" + messages +
                '}';
    }
}
