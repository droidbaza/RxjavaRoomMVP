package com.droidbaza.todo.second;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.droidbaza.todo.R;
import com.droidbaza.todo.database.DbClient;
import com.droidbaza.todo.model.Note;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by droidbaza on 16/10/19.
 */
public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.editText)
    EditText etName;
    private long id;
    private Note note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_notes);
        ButterKnife.bind(this);

         note = new Note();

         Intent intent = getIntent();
         id = intent.getLongExtra(String.valueOf(R.string.KEY),0);
         if(id!=0){
            DbClient
                    .getInstance(getApplicationContext())
                    .getMyDb()
                    .myDao()
                    .getById(id).observe(this, note ->
                    etName.setText(note.getName())
                    );
         }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String mynote = etName.getText().toString().trim();

        if(id!= 0){
            note.setId(id);
            note.setName(mynote);

            Completable.fromAction(() -> DbClient.getInstance(this)
                    .getMyDb().myDao().update(note)).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe();

        }else {
            note.setName(mynote);
            Single.fromCallable(() ->
                    DbClient.getInstance(getApplicationContext())
                            .getMyDb().myDao().insert(note))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe();
        }

    }

}

