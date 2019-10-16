package com.droidbaza.todo.main;

import android.widget.Button;

import androidx.fragment.app.FragmentActivity;
import com.droidbaza.todo.model.Note;
import java.util.List;
/**
 * Created by droidbaza on 16/10/19.
 */
public interface MainContract {
    interface MainView {
        void showMyNotes(List<Note> myNotes);
    }

    interface MainPresenter {
        void getMyNotes(FragmentActivity activity);
    }
}
