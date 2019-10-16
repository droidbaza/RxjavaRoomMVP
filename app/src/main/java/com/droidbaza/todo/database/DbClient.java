package com.droidbaza.todo.database;
import androidx.room.Room;
import android.content.Context;

import com.droidbaza.todo.database.MyDatabase;

public class DbClient {

    private static DbClient mInstance;
    private MyDatabase myDb;

    private DbClient(Context context) {
        myDb = Room.databaseBuilder(context, MyDatabase.class, "TabNote").build();
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
