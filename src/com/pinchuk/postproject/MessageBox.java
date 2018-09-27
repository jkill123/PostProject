package com.pinchuk.postproject;

import java.util.*;

public class MessageBox {
    private MainOffice mainoffice;
    private List<Message> messages;
    private static long nextIndex =0;



    public MessageBox() {
        this(100);
    }


    public MessageBox(int count) {
        messages = new ArrayList<>(count);
        mainoffice = new MainOffice();
    }


    public long add(Message.MessageCategory category, String sender, String addres, String receiver){
       Message message = new Message(category, sender, addres,receiver);
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
                iterator.remove();
                return  true;
            }

        }

       return false;
    } //удаление письма

    public List<Long> sendToMianOffice(){
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
