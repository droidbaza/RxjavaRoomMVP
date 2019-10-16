package com.droidbaza.todo.database;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.droidbaza.todo.model.Note;
import java.util.List;
/**
 * Created by droidbaza on 16/10/19.
 */

@Dao
public interface MyDao {

    @Query("SELECT * FROM note")
    LiveData<List<Note>>getAll();

    @Query("SELECT * FROM note WHERE id = :noteId")
    LiveData<Note> getById(long noteId);

    @Insert
    long insert(Note note);

    @Delete
    void delete(Note note);

    @Update
    void update(Note note);
}
