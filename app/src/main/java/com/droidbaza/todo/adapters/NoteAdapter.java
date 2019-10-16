package com.droidbaza.todo.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
        TextView tvName;
        Button btnDelete;

        MyViewHolder(View view) {
            super(view);
            tvName = view.findViewById(R.id.tv_name);
            btnDelete = view.findViewById(R.id.bt_del);
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
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SecondActivity.class);
                i.putExtra("nameNote",note.getName());
                context.startActivity(i);
                // c.startActivity(i);
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onButtonClicked(note);
            }
        });
    }
    @Override
    public int getItemCount() {
        return noteList.size();
    }

}
