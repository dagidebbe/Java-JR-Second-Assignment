package com.company;

import sun.awt.UNIXToolkit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.sql.*;

/**
 *
 */

public class test {
    public static final String DB_NAME = "newit.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/dougmengistu/TrailJava/IntermediateClass/"+DB_NAME;
    public static final String TABLE_FORUM = "FORUM";
    public static final String TABLE_USER= "USER";
    public static final String TABLE_MESSAGE = "MESSAGE";
    public static final String TABLE_POST = "POST";
    public static final String COLUMN_USER_ID = "USER_ID";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_DOB = "USER_DOB";
    public static final String COLUMN_MESSAGE_ID= "MESSAGE_ID";
    public static final String COLUMN_MESSAGE_DATE = "MESSAGE_DATE";
    public static final String COLUMN_MESSAGE_AUTHOR = "MESSAGE_AUTHOR";
    public static final String COLUMN_MESSAGE_MESSAGE = "MESSAGE_MESSAGE";
    public static final String COLUMN_MESSAGE_TITLE = "MESSAGE_TITLE";
    public static final String COLUMN_POST_ID = "POST_ID";
    public static final String COLUMN_POST_TITLE = "POST_TITLE";
    public static final String COLUMN_POST_DATE = "POST_DATE";
    public static final String COLUMN_POST_AUTHOR = "POST_AUTHOR";
    public static final String COLUMN_POST_MESSAGES = "POST_MESSAGES";
    public static final String COLUMN_FORUM_ID = "FORUM_ID";




    public static void main(String[] args) {


        ArrayList<user> user = new ArrayList<com.company.user>();
        user.add(new user("Doug", new Date()));
        user.add(new user("Jake", new Date()));


        ArrayList<Author> author = new ArrayList<Author>();
        author.add(new Author("DougAuthor", new Date()));
        author.add(new Author("JakeAuthor", new Date()));
        author.add(new Author("RaphaelAuthor", new Date()));
        author.add(new Author("StephenAuthor", new Date()));

        ArrayList<Messages> m = new ArrayList<Messages>();
        m.add(new Messages(new Date(), author.get(0), "This is the message"));
        m.add(new Messages(new Date(), author.get(1), "This is the second message"));
//        Messages m1 = new Messages(new Date(), author.get(1),"This is the second message");

        ArrayList<Messages> m1 = new ArrayList<Messages>();
        m.add(new Messages(new Date(), author.get(2), "Third message"));
        m.add(new Messages(new Date(), author.get(3), "Fourth message"));

        Post p = new Post("Post title", new Date(), author.get(0), m);
        Post p1 = new Post("Second Post", new Date(), author.get(3), m1);

        ArrayList<Post> p2 = new ArrayList<Post>();
        p2.add(p);
        p2.add(p1);
        Forum f = new Forum(p2);


//        for (int i = 0; i < user.size(); i++) {
//
//            System.out.println(user.get(i).getName() + "\t\t" + user.get(i).getDob());
//            System.out.println("=====================================================");
//        }

//        for (int i = 0; i < author.size(); i++) {
//            System.out.println(author.get(i).getName() + "\t\t" + author.get(i).getDob());
//            System.out.println("=====================================================");
//
//        }

//        for (int i = 0; i < m.size(); i++) {
//            System.out.println(m.get(i).getAuthor().getName() + "\t\t" + m.get(i).getMessage() + "\t\t" + m.get(i).getAuthor().getName());
//            System.out.println("=====================================================");
//        }

//        for (int i = 0; i < p.getMessages().size(); i++) {
//
//            System.out.println("Post title is = " + p.getTitle() + "\n" +
//                    "Post date is = " + p.getDate() + "\n" +
//                    "Post message = " + p.getMessages().get(i).getMessage());
//            System.out.println("=====================================================");
//        }



//        for (int i = 0; i < f.getPosts().size(); i++) {
//            for (int x = 0; x < f.getPosts().get(i).getMessages().size(); x++) {
//                System.out.println(f.getPosts().get(i).getMessages().get(x).getAuthor().getName() + "\t\t" + f.getPosts().get(i).getMessages().get(x).getMessage());
//            }
//        }


        try {
            Connection conn = DriverManager.getConnection(test.CONNECTION_STRING);
            Statement st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS " + TABLE_MESSAGE + " (" +
                    COLUMN_POST_ID + " INT, " +
                            COLUMN_USER_ID + " INT, " +
                            COLUMN_MESSAGE_ID + " INT, " +
                            COLUMN_MESSAGE_DATE + " TEXT, " +
                            COLUMN_USER_NAME + " TEXT, " +
                            COLUMN_MESSAGE_MESSAGE + " TEXT)");

            st.execute("CREATE TABLE IF NOT EXISTS " + TABLE_POST +
                    " (" +  COLUMN_FORUM_ID + " INT, " +
                            COLUMN_POST_ID + " INT, " +
                            COLUMN_POST_TITLE + " TEXT, " +
                            COLUMN_POST_DATE + " TEXT, " +
                            COLUMN_USER_ID + " INT, " +
                            COLUMN_MESSAGE_ID + " TEXT)");

            st.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USER +
                    " (" +  COLUMN_USER_ID + " INT, " +
                            COLUMN_USER_NAME + " TEXT, " +
                            COLUMN_USER_DOB + " TEXT)");

            insertUser(st,user);
            insertMessage(st, p);
            insertMessage(st, p1);
            insertPost(st, f);

            ResultSet resu=  st.getResultSet();
            resu = st.executeQuery("SELECT * FROM "+TABLE_USER);
            while(resu.next()) {
                System.out.println(resu.getInt(COLUMN_USER_ID) + " " +
                        resu.getString(COLUMN_USER_NAME) + " " +
                        resu.getString(COLUMN_USER_DOB));
            }

        } catch (SQLException e ) {
            System.out.println("Something went wrong: " + e.getMessage() );
        }
    }


    public static void insertUser(Statement st, user user) throws SQLException {
        st.execute("insert into " + TABLE_USER + " VALUES(" +user.getUserid()+ ", '"+ user.getName() + "', '" + dateformat(user.getDob()) + "') ");
    }
    public static void insertUser(Statement st, ArrayList<user> users) throws SQLException {
        for (int i = 0; i < users.size(); i++) {
            user user = users.get(i);
            st.execute("insert into " + TABLE_USER + " VALUES(" + user.getUserid() + ", '" + user.getName() + "', '" + dateformat(user.getDob()) + "') ");
        }
    }

    public static void insertMessage(Statement st, Post post) throws SQLException {
        for (int i = 0; i < post.getMessages().size(); i++) {
            st.execute("insert into " + TABLE_MESSAGE +
                    " VALUES(" + post.getPostId() + ", " +
                                post.getMessages().get(i).getAuthor().getUserid() + ", " +
                                post.getMessages().get(i).getMessageId() + ", '" +
                                dateformat(post.getMessages().get(i).getDate()) + "', '" +
                                post.getMessages().get(i).getAuthor().getName() + "', '" +
                                post.getMessages().get(i).getMessage()  + "') ");
        }
    }

    public static void insertMessage(Statement st, ArrayList<Post> posts) throws SQLException {
        for (int e=0; e<posts.size();e++) {
            Post post = posts.get(e);
            for (int i = 0; i < post.getMessages().size(); i++) {
                st.execute("insert into " + TABLE_MESSAGE + " VALUES("
                        + post.getPostId() + ", " +
                        post.getMessages().get(i).getAuthor().getUserid() + ", " +
                        post.getMessages().get(i).getMessageId() + ", '" +
                        dateformat(post.getMessages().get(i).getDate()) + "', '" +
                        post.getMessages().get(i).getAuthor().getName() + "', '" +
                        post.getMessages().get(i).getMessage()  + "') ");
            }
        }
    }

        public static void insertPost(Statement st, Forum forum) throws SQLException {
            for (int i = 0; i < forum.getPosts().size(); i++) {
                for (int x = 0; x < forum.getPosts().get(i).getMessages().size(); x++) {

                    st.execute("insert into " + TABLE_POST + " VALUES(" +
                            forum.getForumId()+", "+
                            forum.getPosts().get(i).getPostId() + ", '" +
                            forum.getPosts().get(i).getTitle() + "', '" +
                            dateformat(forum.getPosts().get(i).getDate()) + "', " +
                            forum.getPosts().get(i).getAuthor().getUserid() + ", " +
                            forum.getPosts().get(i).getMessages().get(x).getMessageId() + ") ");
                }
            }
        }
    public static void insertPost(Statement st, ArrayList<Forum> forums) throws SQLException {
        for(int k =0; k<forums.size();k++) {
            Forum forum = forums.get(k);
        for (int i = 0; i < forum.getPosts().size(); i++) {
                for (int x = 0; x < forum.getPosts().get(i).getMessages().size(); x++) {

                    st.execute("insert into " + TABLE_POST + " VALUES(" +
                            forum.getForumId()+", "+
                            forum.getPosts().get(i).getPostId() + ", '" +
                            forum.getPosts().get(i).getTitle() + "', '" +
                            dateformat(forum.getPosts().get(i).getDate()) + "', " +
                            forum.getPosts().get(i).getAuthor().getUserid() + ", " +
                            forum.getPosts().get(i).getMessages().get(x).getMessageId() + ") ");
                }
            }
        }
    }



    public static String dateformat(Date format) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
        String result = formatter.format(format);
        return result;
    }

    public static Date dateFormatToString(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");

        try {
            Date date = formatter.parse(format);
            return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
