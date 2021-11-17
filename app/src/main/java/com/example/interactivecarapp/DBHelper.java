package com.example.interactivecarapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_PATH = "/data/data/com.example.interactivecarapp/databases/";
    private static final String DB_NAME = "IntCarAppDB.db"; //yourDB file name
    private static String emailKey = "email";
    private static String passKey = "password";
    private static String addKey = "address";
    private static String zipKey = "zip";
    private static String phoneKey = "phone";
    private static String vinKey = "vin";
    private static String firstNameKey = "firstname";
    private static String lastNameKey = "lastname";
    private static String tableKey = "user";
    private SQLiteDatabase db;
    private Context myContext;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }

    private boolean checkDataBase() {

        SQLiteDatabase checkDB = null;

        try {
            String myPath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        } catch (SQLiteException e) {

            //database does't exist yet.
        }
        if (checkDB != null) {

            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    public void createDataBase() throws IOException {

        boolean dbExist = checkDataBase();

        if (dbExist) {
            //do nothing - database already exist
        } else {

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new Error("Error copying database");

            }
        }

    }


    public void openDataBase() {
        //Open the database
        String myPath = DB_PATH + DB_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    @Override
    public synchronized void close() {

        if (db != null)
            db.close();

        super.close();

    }

    private void copyDataBase() throws IOException {

        //Open your local db as the input file
        InputStream myInput = myContext.getAssets().open(DB_NAME + ".db");

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db file that was created by DBHelper as an output file
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the input file to the output file
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams or the output file
        myOutput.flush();//write to output file
        myOutput.close();
        myInput.close();

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<User> GetUsers()
    {
        // create query for db
        String q = "SELECT * FROM user";
        Cursor cursor = db.rawQuery(q, null);

        // create list to hold data
        ArrayList<User> userList = new ArrayList<>();

        // move cursor to first position
        if (cursor.moveToFirst())
        {
            do // add data from cursor to userList
            {
                userList.add(new User(
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getInt(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8)));
            }
            while (cursor.moveToNext()); // move to next cursor
        }
        cursor.close(); // close that little cursor guy
        return userList; // make papa proud
    }

    public void AddUser(String email, String password, String address, int zip, String phone,
                        String vin, String firstName, String lastName)
    {
        // create new content value object
        ContentValues values = new ContentValues();

        // pass values and their keys
        values.put(emailKey, email);
        values.put(passKey, password);
        values.put(addKey, address);
        values.put(zipKey, zip);
        values.put(phoneKey, phone);
        values.put(vinKey, vin);
        values.put(firstNameKey, firstName);
        values.put(lastNameKey, lastName);

        db.insert(tableKey, null, values);
    }
}


