package com.droidbaza.todo.main;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.droidbaza.todo.R;
import com.droidbaza.todo.adapters.AdapterListener;
import com.droidbaza.todo.adapters.NoteAdapter;
import com.droidbaza.todo.database.DbClient;
import com.droidbaza.todo.model.Note;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/**
 * Created by droidbaza on 16/10/19.
 */

public class MainFragment extends Fragment implements MainContract.MainView, AdapterListener {


    @BindView(R.id.rv_notes)
    RecyclerView rvNotes;

    private Unbinder unbinder;
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
        unbinder = ButterKnife.bind(this,v);
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
                    Completable.fromAction(() -> DbClient.getInstance(getContext())
                            .getMyDb().myDao().delete(note)).subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe();
                    mAdapter.notifyDataSetChanged();
                })
                .setNegativeButton("Нет", (dialog, id) -> {
                });
        builder.create().show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
