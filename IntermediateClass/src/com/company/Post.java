package com.company;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class Post  {
    public static long postIdCounter=0;
    private long postId = 0;
    private String title;
    private Date date;
    private user author;
    private ArrayList<Messages> messages;

    public Post(String title, Date date, user author, ArrayList<Messages> messages) {
        this.title = title;
        this.date = date;
        this.messages = messages;
        this.author = author;
        this.postId=postIdCounter ;
        postIdCounter++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public user getAuthor() { return author;}

    public void setAuthor(user author) {this.author = author;}

    public ArrayList<Messages> getMessages() {
        return messages;
    }

    public void setMessages(ArrayList<Messages> messages) {
        this.messages = messages;
    }

    public static long getPostIdCounter() {
        return postIdCounter;
    }

    public static void setPostIdCounter(long postIdCounter) {
        Post.postIdCounter = postIdCounter;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }
}
