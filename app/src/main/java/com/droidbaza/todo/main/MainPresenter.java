package com.droidbaza.todo.main;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.droidbaza.todo.database.DbClient;
/**
 * Created by droidbaza on 16/10/19.
 */
public class MainPresenter implements MainContract.MainPresenter {
    private MainContract.MainView view;
    private Context context;

    MainPresenter(MainContract.MainView view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getMyNotes(FragmentActivity activity) {

            DbClient
                    .getInstance(context)
                    .getMyDb()
                    .myDao()
                    .getAll().observe(activity, notes -> {
                view.showMyNotes(notes);
            });
    }
}

