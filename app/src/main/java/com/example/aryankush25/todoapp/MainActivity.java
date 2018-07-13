package com.example.aryankush25.todoapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button additem;
    ListView listview;
    private TodoDbHelper mDbHelper;
    TodoAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbHelper = new TodoDbHelper(this);
        //getList();

        listview = findViewById(R.id.list);
        additem = findViewById(R.id.Add);
        Cursor c = mDbHelper.readItem();
        arrayAdapter = new TodoAdapter(this, c);
        listview.setAdapter(arrayAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                setContentView(R.layout.list_item);
                Toast.makeText(getApplicationContext(), "task", Toast.LENGTH_SHORT).show();

            }
        });

        additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AddItem.class);
                startActivity(intent);
            }
        });
    }
}





