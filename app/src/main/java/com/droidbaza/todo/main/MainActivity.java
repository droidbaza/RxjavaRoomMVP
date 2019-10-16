package com.droidbaza.todo.main;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.droidbaza.todo.R;
import com.droidbaza.todo.second.SecondActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * Created by droidbaza on 16/10/19.
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MainFragment mainFragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.cont, mainFragment)
                .commit();

    }
    @OnClick(R.id.fab)
    public void onButtonClick(View view) {
        Intent i = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(i);
    }

}
