package com.example.lado.notes_sql;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText theme;
    EditText userInputs;
    Button saving;
    Button deliting; Button open; DBHandler dbHandler;
    TextView listView;
    private final List<UserInput> noteList = new ArrayList<UserInput>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        theme = (EditText) findViewById(R.id.text_note_title);
        userInputs = (EditText) findViewById(R.id.text_note_content);
        saving = (Button) findViewById(R.id.button_save);
        deliting = (Button) findViewById(R.id.button_cancel);
        listView = (TextView) findViewById(R.id.listView);
        open = (Button) findViewById(R.id.button_open);
        dbHandler = new DBHandler(this, null, null, 1);
        printDatabase();
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, EditNotes.class);
                startActivity(myIntent);
            }
        });
    }

    public void printDatabase() {
        String dbString = dbHandler.databaseToString();
        listView.setText(dbString);
        //theme.setText("");
    }
}
