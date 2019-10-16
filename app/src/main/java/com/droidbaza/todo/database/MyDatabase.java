package com.droidbaza.todo.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.droidbaza.todo.model.Note;
/**
 * Created by droidbaza on 16/10/19.
 */
@Database(entities = {Note.class}, version = 2,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}