package com.droidbaza.todo.main;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.droidbaza.todo.R;
import com.droidbaza.todo.adapters.AdapterListener;
import com.droidbaza.todo.adapters.NoteAdapter;
import com.droidbaza.todo.async.DeleteTask;
import com.droidbaza.todo.model.Note;
import java.util.List;

public class MainFragment extends Fragment implements MainContract.MainView, AdapterListener {


    private RecyclerView rvNotes;
    private NoteAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainContract.MainPresenter presenter = new MainPresenter(this, getContext());
        presenter.getMyNotes(getActivity());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_main, container, false);
        rvNotes = v.findViewById(R.id.rv_notes);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rvNotes.setLayoutManager(llm);
        return v;
    }

    @Override
    public void showMyNotes(List<Note> myNotes) {

        mAdapter = new NoteAdapter(myNotes,getContext(),this);
        mAdapter.notifyDataSetChanged();
        rvNotes.setAdapter(mAdapter);
    }

    @Override
    public void onButtonClicked(Note note) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage("Удалить заметку?")
                .setCancelable(false)
                .setPositiveButton("Да", (dialog, id) -> {
                    new DeleteTask(note,getContext()).execute();
                    mAdapter.notifyDataSetChanged();
                })
                .setNegativeButton("Нет", (dialog, id) -> {
                });
        builder.create().show();
    }
}
