package com.droidbaza.todo.async;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import com.droidbaza.todo.database.DbClient;
import com.droidbaza.todo.model.Note;

public class DeleteTask extends AsyncTask<Void, Void, Void> {

    private Note note;
    @SuppressLint("StaticFieldLeak")
    private Context context;

    public DeleteTask(Note note, Context context) {
        this.note = note;
        this.context = context;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        DbClient.getInstance(context).getMyDb()
                .myDao()
                .delete(note);
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
    }
}
