package com.example.aryankush25.todoapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TodoAdapter extends CursorAdapter {

    private final MainActivity activity;

    public TodoAdapter(MainActivity context, Cursor c) {
        super(context, c, 0);
        this.activity = context;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, final Context context, final Cursor cursor) {
        TextView titleTextView = view.findViewById(R.id.title);

        TextView descriptionTextView = view.findViewById(R.id.sample_text);

        String name = cursor.getString(cursor.getColumnIndex(TodoContract.TodoEntry.COLUMN_TODO_TITLE));

        String description = cursor.getString(cursor.getColumnIndex(TodoContract.TodoEntry.COLUMN_TODO_SAMPLE_TEXT));

        titleTextView.setText(name);

        descriptionTextView.setText(description);
    }
}