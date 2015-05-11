package db.example.ngondo.dbexample;

/**
 * Created by ngondo on 11/05/15.
 */
//This class defines the tables in your db
public class UserContact {

    public static abstract class NewUserInfo{
        //Constants for the DB ie columns
        public static final String USER_NAME="user_name";
        public static final String USER_MOB="user_mob";
        public static final String USER_EMAIL="user_email";
        //Name of the table
        public static final String TABLE_NAME="user_info";

    }
}
