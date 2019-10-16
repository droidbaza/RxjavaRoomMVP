package com.droidbaza.todo.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.droidbaza.todo.R;
import com.droidbaza.todo.second.SecondActivity;
import com.droidbaza.todo.model.Note;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * Created by droidbaza on 16/10/19.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHolder> {

    private Context context;

    public NoteAdapter(List<Note> noteList, Context context, AdapterListener listener) {
        this.noteList = noteList;
        this.listener = listener;
        this.context = context;
    }

    private List<Note> noteList;
    private AdapterListener listener;



    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.bt_del)
        Button btnDelete;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final Note note = noteList.get(position);
        holder.tvName.setText(note.getName());
        holder.itemView.setOnClickListener(v -> {
            Intent i = new Intent(context, SecondActivity.class);
            i.putExtra(String.valueOf(R.string.KEY),note.getId());
            context.startActivity(i);
        });

        holder.btnDelete.setOnClickListener(v -> listener.onButtonClicked(note));
    }
    @Override
    public int getItemCount() {
        return noteList.size();
    }

}
