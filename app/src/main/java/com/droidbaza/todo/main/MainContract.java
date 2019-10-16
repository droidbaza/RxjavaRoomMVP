package com.droidbaza.todo.main;

import androidx.fragment.app.FragmentActivity;
import com.droidbaza.todo.model.Note;
import java.util.List;

public interface MainContract {
    interface MainView {

        void showMyNotes(List<Note> myNotes);

    }

    interface MainPresenter {
        void getMyNotes(FragmentActivity activity);

    }
}
