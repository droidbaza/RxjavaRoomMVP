package com.droidbaza.todo.database;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.droidbaza.todo.model.Note;

@Database(entities = {Note.class}, version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}