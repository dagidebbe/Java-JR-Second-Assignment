package com.company;

import java.util.Date;

/**
 *
 */
public class Messages {
    public static long messageIdCounter=0;
    private long messageId=0;
    private Date date;
    private user author;
    private String message;

    public Messages(Date date, user author, String  message) {
        this.date = date;
        this.author = author;
        this.message = message;
        this.messageId=messageIdCounter;
        messageIdCounter++;
    }

    public Messages( Date date, user author, String  message, long messageId) {
        this.date = date;
        this.author = author;
        this.message = message;
        this.messageId=messageId;
        messageIdCounter++;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public user getAuthor() {
        return author;
    }

    public void setAuthor(user author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static long getMessageIdCounter() {
        return messageIdCounter;
    }

    public static void setMessageIdCounter(long messageIdCounter) {
        Messages.messageIdCounter = messageIdCounter;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }


}
