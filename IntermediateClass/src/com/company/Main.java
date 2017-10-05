//package com.company;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.sql.*;
//
//public class Main {
//    public static final String DB_NAME = "test";
//    public static final String CONNECTION_STRING = "jdbc:h2:~/"+DB_NAME;
//    public static final String TABLE_CONTACTS = "CONTACTS";
//    public static final String COLUMN_NAME = "name";
//    public static final String COLUMN_PHONE = "phone";
//    public static final String COLUMN_EMAIL = "email";
//
//
//    public static void main(String[] args) {
//	// write your code here
////        user u = new user("Doug", new Date());
////        Author a = new Author();
////        Messages m = new Messages(new Date(),a, "Here is the message" );
////        Post p = new Post("Post Title", new Date(), m);
////        Forum f = new Forum("Fourm Title", p, m, a, u);
//
//
//
//        try {
//
////            Class.forName("org.h2.Driver");
////            Connection conn = DriverManager.getConnection("jdbc:h2:test");
//            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            Statement st = conn.createStatement();
//            st.execute("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);
//
//
//            st.execute("CREATE TABLE IF NOT EXISTS "+TABLE_CONTACTS+
//                            " ("+COLUMN_NAME+" TEXT, "+COLUMN_PHONE+
//                            " INTEGER, "+COLUMN_EMAIL+" TEXT)");
//
////            st.execute("INSERT INTO "+TABLE_CONTACTS+" " +
////                            " ("+COLUMN_NAME+ "," +
////                                COLUMN_PHONE+ "," +
////                                COLUMN_EMAIL + " ) "
////                            + "VALUES('Tim', 654743,'doug@email')");
//
//            insertContact(st,"Tims", 4342233,"tim@ishere.com");
//
////            st.execute("INSERT INTO "+TABLE_CONTACTS+" " +
////                    " ("+COLUMN_NAME+ "," +
////                    COLUMN_PHONE+ "," +
////                    COLUMN_EMAIL + " ) "
////                    + "VALUES('Joe', 342342,'joe@email')");
//
//            insertContact(st, "Joes", 6566767, "joe@emailishere.com");
//
////            st.execute("INSERT INTO "+TABLE_CONTACTS+" " +
////                    " ("+COLUMN_NAME+ "," +
////                    COLUMN_PHONE+ "," +
////                    COLUMN_EMAIL + " ) "
////                    + "VALUES('Jane', 422343,'jane@somewhere.com')");
//
//            insertContact(st, "Janes", 34534543, "Jane@emailishere.com");
//
////            st.execute("INSERT INTO "+TABLE_CONTACTS+" " +
////                    " ("+COLUMN_NAME+ "," +
////                    COLUMN_PHONE+ "," +
////                    COLUMN_EMAIL + " ) "
////                    + "VALUES('Fido', 422343,'dog@somewhere.com')");
//
//            insertContact(st, "Fidos",56566767, "Fido@ishere.com");
//
//            st.execute("UPDATE " + TABLE_CONTACTS+ " SET "+
//                            COLUMN_PHONE + "=556321" +
//                            " WHERE " + COLUMN_NAME +"='Jane'" );
//
//            st.execute("DELETE FROM "+TABLE_CONTACTS+ " WHERE " + COLUMN_NAME + "='Joe'");
//
//
////            st.execute("INSERT INTO CONTACTS (name, phone, email)" +
////                        "VALUES('Tim', 6545678, 'tim@email.com')");
////            st.execute("SELECT * FROM CONTACTS");
////            ResultSet results=  st.getResultSet();
//            ResultSet results = st.executeQuery("SELECT * FROM "+TABLE_CONTACTS);
//            while(results.next()) {
//                System.out.println(results.getString(COLUMN_NAME) + " " +
//                                    results.getInt(COLUMN_PHONE)+ " " +
//                                    results.getString(COLUMN_EMAIL));
//            }
//            results.close();
//
//
//            st.close();
//            conn.close();
//
//        } catch (SQLException e) {
//            System.out.println("Something went wrong: " + e.getMessage() );
//        }
//
//
//    }
//    public static void insertContact(Statement st, String name, int phone, String email) throws SQLException {
//        st.execute("INSERT INTO "+TABLE_CONTACTS+" " +
//                " ("+COLUMN_NAME+ "," +
//                COLUMN_PHONE+ "," +
//                COLUMN_EMAIL + " ) "
//                + "VALUES('"+name+"', "+phone+",'"+email+"')");
//    }
//    public static void dropContact(Statement st) throws  SQLException {
//        st.execute("DROP TABLE IF EXISTS "+ TABLE_CONTACTS);
//    }
//
//    public static void updateContact(Statement st, int oldcontact, String name) throws SQLException{
//        st.execute("UPDATE " + TABLE_CONTACTS+ " SET "+
//                COLUMN_PHONE + "="+oldcontact+
//                " WHERE " + COLUMN_NAME +"='"+name+"'" );
//
//
////        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
////        today = new Date();
////        result = formatter.format(today);
//////        System.out.println("Locale: " + currentLocale.toString());
////        System.out.println("Result: " + result);
////
////        System.out.println(today);
////        dateformat(new Date());
////        dateFormatToString("2017-09-21 15:38:36.612-0400");
////        dateFormatToString(new Date());
//    }
//
//    public static String dateformat(Date format) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
//        String result = formatter.format(format);
//        System.out.println(result);
//        return result;
//
//    }
//
//    public static Date dateFormatToString(String format) {
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
//
//        try {
//
//            Date date = formatter.parse(format);
//            return date;
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        return null;
//
//
//    }
//
//}
//
