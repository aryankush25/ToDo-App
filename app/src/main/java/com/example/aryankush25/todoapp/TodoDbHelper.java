package com.example.aryankush25.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TodoDbHelper extends SQLiteOpenHelper {

    public static final int version= 1;

    public static final String DATABASE_NAME="Todos.db";

    private static final int DATABASE_VERSION = 1;



    public TodoDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(TodoContract.TodoEntry.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TodoContract.TodoEntry.TABLE_NAME);
        onCreate(db);
    }

    public void insertItem(TodoItem item) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TodoContract.TodoEntry.COLUMN_TODO_TITLE, item.getMtitle());
        values.put(TodoContract.TodoEntry.COLUMN_TODO_SAMPLE_TEXT, item.getMsampleText());
        long id = db.insert(TodoContract.TodoEntry.TABLE_NAME, null, values);

    }

    public Cursor readItem() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = { TodoContract.TodoEntry._ID, TodoContract.TodoEntry.COLUMN_TODO_TITLE, TodoContract.TodoEntry.COLUMN_TODO_SAMPLE_TEXT};
        Cursor c = db.query(
                TodoContract.TodoEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return c;
    }
}
