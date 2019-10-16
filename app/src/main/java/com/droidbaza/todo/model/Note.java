package com.droidbaza.todo.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/**
 * Created by droidbaza on 16/10/19.
 */
@Entity
public class Note {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo
    private String name;


}
