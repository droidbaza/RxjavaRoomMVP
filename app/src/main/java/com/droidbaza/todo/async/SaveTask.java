package com.droidbaza.todo.async;
import android.content.Context;
import android.os.AsyncTask;

import com.droidbaza.todo.database.DbClient;
import com.droidbaza.todo.model.Note;
import java.lang.ref.WeakReference;

public class SaveTask extends AsyncTask<Void, Void, Void> {


    private Note note;
    private WeakReference<Context> context;

    public SaveTask(Note note, WeakReference<Context> context) {
        this.note = note;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        DbClient.getInstance(context.get()).getMyDb()
                .myDao()
                .insert(note);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        context.clear();
    }
}

