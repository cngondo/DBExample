package db.example.ngondo.dbexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ngondo on 11/05/15.
 */
//Class to handle db operations
public class UserDbHelper extends SQLiteOpenHelper {
    //Define the db name and db versions
    private static final String DATABASE_NAME="USERINFO.DB";
    private static final int DATABASE_VERSION=1;
    //SQL query to create the table. Note the spaces because the datatypes are not defined.
    //
    private static final String CREATE_QUERY =
            "CREATE TABLE "+ UserContact.NewUserInfo.TABLE_NAME+ "("+ UserContact.NewUserInfo.USER_NAME+" TEXT,"+
                    UserContact.NewUserInfo.USER_MOB+" TEXT,"+ UserContact.NewUserInfo.USER_EMAIL+" TEXT);";


    public UserDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        Log.e("DATABASE OPERATTIONS","Database created/opened...");

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        //display log message after creating the query
        Log.e("DATABASE OPERATTIONS","Table created...");
    }
    //Class to add data to your table
    public void addinformation(String name,String mob,String email,SQLiteDatabase db){
        //Data is inserted in for of map values where the keys rep the column
        //So we use a content value object to capture the keys
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContact.NewUserInfo.USER_NAME,name);
        contentValues.put(UserContact.NewUserInfo.USER_MOB,mob);
        contentValues.put(UserContact.NewUserInfo.USER_EMAIL,email);
        //Now insert the captured info to the db. The insert method takes three args: Table name, Null values and
        //the content values. The null column values are imprtant to tell the android system to put null values just
        //incase there's a null value passed by the content values. Otherwise, it'll not create the row.
        db.insert(UserContact.NewUserInfo.TABLE_NAME,null,contentValues);
        Log.e("DATABASE OPERATTIONS", "Successfully inserted a row...");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
