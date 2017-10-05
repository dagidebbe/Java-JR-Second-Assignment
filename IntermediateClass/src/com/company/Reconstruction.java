package com.company;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 */
public class Reconstruction {

//    ArrayList<user> ReconstructedUsers = new ArrayList<user>();


    public static void rearrangeObject() throws SQLException {
        ArrayList<user> ReconstructedUsers = new ArrayList<user>();
        ArrayList<Messages> ReconstructedMessages = new ArrayList<Messages>();
        ArrayList<Post> ReconstructedP2 = new ArrayList<Post>();

        try {
            Connection conn = DriverManager.getConnection(test.CONNECTION_STRING);
            Statement st = conn.createStatement();

            ResultSet usersTable = st.getResultSet();
            ResultSet userMax = st.getResultSet();
//            ResultSet resultMax = st.executeQuery("SELECT "+ test.TABLE_USER+"."+test.COLUMN_USER_ID+ test.COLUMN_USER_NAME+ test.COLUMN_USER_DOB+ test.COLUMN_USER_ID+  " FROM " + test.TABLE_USER);
            ResultSet USER_RESULT = st.executeQuery("SELECT * FROM " + test.TABLE_USER);
            ResultSet USER_MESSAGE_RESULT = st.executeQuery("SELECT "+
                    test.TABLE_USER+"."+test.COLUMN_USER_ID + //" as t_u_id, "+
                    test.TABLE_USER+"."+test.COLUMN_USER_NAME + //"as t_u_name,"+
                    test.TABLE_USER+"."+test.COLUMN_USER_DOB + //"as t_u_dob,"+
                    test.TABLE_MESSAGE+"."+test.COLUMN_USER_ID + //"as t_m_uid,"+
                    test.TABLE_MESSAGE+"."+test.COLUMN_MESSAGE_ID + //"as t_m_id,"+
                    test.TABLE_MESSAGE+"."+test.COLUMN_MESSAGE_DATE + //"as t_m_date,"+
                    test.TABLE_MESSAGE+"."+test.COLUMN_USER_NAME + //"as t_m_uname,"+
                    test.TABLE_MESSAGE+"."+test.COLUMN_MESSAGE_MESSAGE + //"as t_m_uname,"+
                    test.TABLE_POST+"."+test.COLUMN_FORUM_ID + //"as t_p_forumid,"+
                    test.TABLE_POST+"."+test.COLUMN_POST_ID + //"as t_p_postid,"+
                    test.TABLE_POST+"."+test.COLUMN_POST_TITLE + //"as t_p_title,"+
                    test.TABLE_POST+"."+test.COLUMN_POST_DATE + //"as t_p_date,"+
                    test.TABLE_POST+"."+test.COLUMN_USER_ID + //"as t_p_uid,"+
                    test.TABLE_POST+"."+test.COLUMN_MESSAGE_ID + //"as t_p_messageid"+
                    " FROM " + test.TABLE_MESSAGE +" JOIN " + test.TABLE_USER+ " ON " + test.TABLE_USER+"."+test.COLUMN_USER_ID + " == " + test.TABLE_MESSAGE+"."+ test.COLUMN_USER_ID +
                                                " JOIN " + test.TABLE_POST+ " ON " + test.TABLE_USER+"."+test.COLUMN_USER_ID + " == " + test.TABLE_MESSAGE+"."+ test.COLUMN_USER_ID);




            while (USER_RESULT.next()) {

//                ArrayList<Messages> ReconstructedM = new ArrayList<Messages>();
//                ArrayList<Messages> ReconstructedM1 = new ArrayList<Messages>();
//                ArrayList<Post> ReconstructedP2 = new ArrayList<Post>();
                long userID=USER_MESSAGE_RESULT.getInt(test.TABLE_USER+"."+test.COLUMN_USER_ID);
                String userString=USER_MESSAGE_RESULT.getString(test.TABLE_USER+"."+test.COLUMN_USER_NAME);
                String userDate = USER_MESSAGE_RESULT.getString( test.TABLE_USER+"."+test.COLUMN_USER_DOB);
                long messageUserID = USER_MESSAGE_RESULT.getLong(test.TABLE_MESSAGE+"."+test.COLUMN_USER_ID);
                long messageMessageID = USER_MESSAGE_RESULT.getLong(test.TABLE_MESSAGE+"."+test.COLUMN_MESSAGE_ID);
                String messageMessageDate = USER_MESSAGE_RESULT.getString(test.TABLE_MESSAGE+"."+test.COLUMN_MESSAGE_DATE);
                String messageName = USER_MESSAGE_RESULT.getString(test.TABLE_MESSAGE+"."+test.COLUMN_USER_NAME);
                String message_Message = USER_MESSAGE_RESULT.getString(test.TABLE_MESSAGE+"."+test.COLUMN_MESSAGE_MESSAGE);
                long forumID =  USER_MESSAGE_RESULT.getInt(test.TABLE_POST+"."+test.COLUMN_FORUM_ID);
                long postID = USER_MESSAGE_RESULT.getInt(test.TABLE_POST+"."+test.COLUMN_POST_ID );
                String postTitle = USER_MESSAGE_RESULT.getString(test.TABLE_POST+"."+test.COLUMN_POST_TITLE);
                String postDate = USER_MESSAGE_RESULT.getString( test.TABLE_POST+"."+test.COLUMN_POST_DATE);
                long postUserID = USER_MESSAGE_RESULT.getInt(test.TABLE_POST+"."+test.COLUMN_USER_ID);
                long postMessageID = USER_MESSAGE_RESULT.getInt(test.TABLE_POST+"."+test.COLUMN_MESSAGE_ID);



//                user u = new user(userID, userString,test.dateFormatToString(userDate));
//                Messages m = new Messages(new Messages(test.dateFormatToString(messageMessageDate),u,message_Message));
                ReconstructedUsers.add(new user(userID, userString,test.dateFormatToString(userDate)));

//                ReconstructedMessages.add(new Messages(test.dateFormatToString(messageMessageDate),getuser(userID, ReconstructedUsers),message_Message));

                ReconstructedMessages.add(new Messages(test.dateFormatToString(messageMessageDate), getuser(userID, ReconstructedUsers), message_Message, messageMessageID));


                ReconstructedP2.add(new Post(postTitle,test.dateFormatToString(postDate),getuser(postUserID, ReconstructedUsers), ReconstructedMessages));


            }
            Forum fs = new Forum(ReconstructedP2);
                    for (int i = 0; i < fs.getPosts().size(); i++) {
            for (int x = 0; x < fs.getPosts().get(i).getMessages().size(); x++) {
                System.out.println(fs.getPosts().get(i).getMessages().get(x).getAuthor().getName() + "\t\t" + fs.getPosts().get(i).getMessages().get(x).getMessage());
            }
        }


            USER_RESULT.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static user getuser(long id, ArrayList<user> object) {
        for (int i = 0; i < object.size(); i++) {
            if (id == object.get(i).getUserid()) {
                return object.get(i);
            }



        }

        return null;
    }

}