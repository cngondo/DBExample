package db.example.ngondo.dbexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class CreateContact extends ActionBarActivity {
    EditText contactName,contactMobile,contactEmail;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);
        contactName=(EditText)findViewById(R.id.add_name);
        contactMobile=(EditText)findViewById(R.id.add_number);
        contactEmail=(EditText)findViewById(R.id.add_email);
    }
    //Method will be invoked when the button is clicked
    public void addContact(View v){
        //Capture the information from the form
        String name = contactName.getText().toString();
        String mob = contactMobile.getText().toString();
        String email = contactEmail.getText().toString();
        //Now insert to the DB
        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        //Adds a row of data to the DB
        userDbHelper.addinformation(name,mob,email,sqLiteDatabase);
        //Toast an output if this is successful
        Toast.makeText(getBaseContext(),"Contact Created",Toast.LENGTH_LONG).show();
        //After adding information, we now close the DB.
        userDbHelper.close();
    }

}
