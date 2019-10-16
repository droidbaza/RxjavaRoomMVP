package com.droidbaza.todo.database;
import androidx.room.Room;
import android.content.Context;

import com.droidbaza.todo.R;

/**
 * Created by droidbaza on 16/10/19.
 */

public class DbClient {

    private static DbClient mInstance;
    private MyDatabase myDb;

    private DbClient(Context context) {
        myDb = Room.databaseBuilder(context, MyDatabase.class, context.getString(R.string.Tab)).build();
    }

    public static synchronized DbClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DbClient(context);
        }
        return mInstance;
    }

    public MyDatabase getMyDb() {
        return myDb;
    }
}
