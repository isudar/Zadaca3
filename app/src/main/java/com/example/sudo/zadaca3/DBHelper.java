package com.example.sudo.zadaca3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/**
 * Created by Sudo on 12.4.2017..
 */

public class DBHelper extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Zadaci.db";

    // Contacts table name
    private static final String TABLE_TASK = "Zadaci";

    // Contacts Table Columns names
    private static final String NASLOV = "naslov";
    private static final String OPIS = "opis";
    private static final String PRIORITET = "prioritet";

    private static DBHelper mInstance = null;
    //The constructor should be kept private:
    private DBHelper (Context context)
    {
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }
    //And the public method to access the instance:
    public static synchronized DBHelper getInstance(Context context)
    {
        if(null == mInstance)
        {
            context = context.getApplicationContext();
            mInstance = new DBHelper(context);
        }
        return  mInstance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CREATE_TASKS_TABLE =
                "CREATE TABLE "+TABLE_TASK+
                        " ("+NASLOV+" TEXT,"+OPIS+" TEXT,"+PRIORITET+" INTEGER);";
        db.execSQL(CREATE_TASKS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TASK);
        onCreate(db);
    }

    public ArrayList<Task> getAllTasks()
    {
        // Usage of a raw query:
        String SELECT_ALL_TASKS = "SELECT "+NASLOV+","
                +OPIS+","+PRIORITET+" FROM "+TABLE_TASK;
        ArrayList<Task> myTask = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor myTaskCursor = database.rawQuery(SELECT_ALL_TASKS, null);
        if(myTaskCursor.moveToFirst())
        {
            do {
                Task task = new Task(
                        myTaskCursor.getString(0),
                        myTaskCursor.getString(1),
                        myTaskCursor.getString(2)
                );
                myTask.add(task);
            }while(myTaskCursor.moveToNext());
        }
        myTaskCursor.close();
        database.close();
        return myTask;
    }
    public void insertCar(Task task) {
        //Using the insert method of the database object:
        ContentValues taskValues = new ContentValues();
        taskValues.put(NASLOV,task.getNaslov());
        taskValues.put(OPIS,task.getSadrzaj());
        taskValues.put(PRIORITET,task.getPrioritet());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_TASK, null ,taskValues);
        db.close();
    }
}
