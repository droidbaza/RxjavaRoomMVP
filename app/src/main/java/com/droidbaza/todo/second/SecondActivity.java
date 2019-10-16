package com.droidbaza.todo.second;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import com.droidbaza.todo.R;
import com.droidbaza.todo.async.SaveTask;
import com.droidbaza.todo.async.UpdateTask;
import com.droidbaza.todo.model.Note;
import java.lang.ref.WeakReference;

public class SecondActivity extends Activity {

    private EditText etName;
    private Note note;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_notes);
        etName = findViewById(R.id.editText);
        note = new Note();
        Intent intent = getIntent();
         name = intent.getStringExtra("nameNote");
        if(name != null){
            etName.setText(name);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String firstName = etName.getText().toString().trim();
        if(name!= null){
            note.setName(firstName);
            WeakReference<Context> context = new WeakReference<>(this);
            new UpdateTask(note,context).execute();

        }else {
            note.setName(firstName);
            WeakReference<Context> context = new WeakReference<>(this);
            new SaveTask(note,context).execute();
        }

    }

}

