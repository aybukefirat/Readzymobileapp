package com.aybukefirat.bookmyapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddBook extends AppCompatActivity {

    EditText bookTitle, bookContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bookTitle= findViewById(R.id.addBookTitle);
        bookContent = findViewById(R.id.addBookContent);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bTitle = bookTitle.getText().toString();
                String bContent = bookContent.getText().toString();
                if(bTitle.isEmpty()==bContent.isEmpty()){
                    Toast.makeText(AddBook.this, "Can not Saved with Empty Field",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}