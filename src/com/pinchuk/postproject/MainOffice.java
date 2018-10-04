package com.pinchuk.postproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainOffice {
    private static final Logger log = LoggerFactory.getLogger(MainOffice.class);

    public boolean queue(Message message){
        log.debug("sending to main office" + message);
        return true;
    }


}
