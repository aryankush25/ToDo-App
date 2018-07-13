package com.example.aryankush25.todoapp;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddItem extends AppCompatActivity {

    Button save;
    Button reset;
    private EditText mTitleEditText;
    private EditText mSampleEditText;
    private  TodoDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Intent intent = getIntent();
        mTitleEditText = findViewById(R.id.edit_title);
        mSampleEditText = findViewById(R.id.sample_edit_text);
        save = findViewById(R.id.save);
        reset = findViewById(R.id.reset);
        dbHelper = new TodoDbHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoItem item = new TodoItem(
                mTitleEditText.getText().toString().trim(),
                mSampleEditText.getText().toString().trim()
                );
                dbHelper.insertItem(item);
                mTitleEditText.setText("");
                mSampleEditText.setText("");
                Toast.makeText(getApplicationContext(), "New Todo added", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddItem.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTitleEditText.setText("");
                mSampleEditText.setText("");
                Intent intent = new Intent(AddItem.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
