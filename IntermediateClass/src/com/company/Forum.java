package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class Forum implements Serializable{
    public static long forumIdCounter=0;
    private long forumId=0;
    private ArrayList<Post> Posts;

    public Forum(ArrayList<Post> posts) {
        Posts = posts;
        this.forumId=forumIdCounter;
        forumIdCounter++;
    }

    public Forum() {

    }

    public void addPost(Post p){
        this.Posts.add(p);

    }

    public ArrayList<Post> getPosts() {

        return Posts;
    }

    public void setPosts(ArrayList<Post> posts) {

        Posts = posts;
    }

    public static long getForumIdCounter() {
        return forumIdCounter;
    }

    public static void setForumIdCounter(long forumIdCounter) {
        Forum.forumIdCounter = forumIdCounter;
    }

    public long getForumId() {
        return forumId;
    }

    public void setForumId(long forumId) {
        this.forumId = forumId;
    }
}
