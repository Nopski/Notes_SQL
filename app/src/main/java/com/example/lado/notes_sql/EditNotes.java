package com.example.lado.notes_sql;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lado on 13/3/18.
 */

public class EditNotes extends AppCompatActivity {
    EditText theme;
    EditText userInputs;
    DBHandler dbHandler; Button saving;
    Button deliting;TextView listView;
    private final List<UserInput> noteList = new ArrayList<UserInput>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_note);
        theme = (EditText) findViewById(R.id.text_note_title);
        userInputs = (EditText) findViewById(R.id.text_note_content);
        saving = (Button) findViewById(R.id.button_save);
        deliting = (Button) findViewById(R.id.button_cancel);
        listView = (TextView) findViewById(R.id.listView);
        dbHandler = new DBHandler(this, null, null, 1);
    }

    public void buttonSaveClicked(View view) {
        UserInput users = new UserInput(theme.getText().toString(), userInputs.getText().toString());
        dbHandler.AddUser(users);
    }

    public void deleteButtonClicked(View view) {
        String inputText = theme.getText().toString();
        String inputTextPass = userInputs.getText().toString();
        dbHandler.DeleteUser(inputText, inputTextPass);
    }
}
