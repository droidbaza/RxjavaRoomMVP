package com.droidbaza.todo.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.droidbaza.todo.adapters.AdapterListener;
import com.droidbaza.todo.async.DeleteTask;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.droidbaza.todo.R;
import com.droidbaza.todo.adapters.NoteAdapter;
import com.droidbaza.todo.model.Note;
import com.droidbaza.todo.second.SecondActivity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.main_fragment);
        if (fragment == null){
            fragment = new MainFragment();
            fm.beginTransaction()
                    .add(R.id.cont,fragment)
                    .commit();

        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(i);
        });


    }

}
