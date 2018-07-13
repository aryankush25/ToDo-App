package com.example.aryankush25.todoapp;

import android.provider.BaseColumns;

public class TodoContract {

    public TodoContract() {}

    public static final class TodoEntry implements BaseColumns {

        public static final String TABLE_NAME = "Todos";

        public static final String _ID = BaseColumns._ID;

        public static final String COLUMN_TODO_TITLE = "productName";

        public static final String COLUMN_TODO_SAMPLE_TEXT = "productPrice";

        public static final String CREATE_STATEMENT = "CREATE TABLE " + TodoContract.TodoEntry.TABLE_NAME + "(" + TodoContract.TodoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + TodoContract.TodoEntry.COLUMN_TODO_TITLE + " TEXT NOT NULL," + TodoContract.TodoEntry.COLUMN_TODO_SAMPLE_TEXT + " TEXT NOT NULL);";
    }
}
