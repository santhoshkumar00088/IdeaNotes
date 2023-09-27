package com.example.ideanotes.model;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideanotes.note.NoteDetails;
import com.example.ideanotes.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<String> titles;
    List<String> content;
    public Adapter(List<String>title,List<String>content){
        this.titles=title;
        this.content=content;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
     holder.noteTitle.setText(titles.get(position));
     holder.noteTitle.setText(content.get(position));
     final Integer code=getRandomcolor();
     holder.mCardview.setCardBackgroundColor(holder.view.getResources().getColor(code,null));

     holder.view.setOnClickListener((v1) -> {
             Intent i=new Intent(v1.getContext(), NoteDetails.class);
             i.putExtra("title",titles.get(position));
             i.putExtra("content",content.get(position));
             i.putExtra("code",code);
             v1.getContext().startActivity(i);


     });
    }

    private int getRandomcolor() {
        List<Integer> colorCode=new ArrayList<>();
        colorCode.add(R.color.red);
        colorCode.add(R.color.blue);
        colorCode.add(R.color.lightGreen);
        colorCode.add(R.color.gray);
        colorCode.add(R.color.lightPurple);
        colorCode.add(R.color.yellow);
        colorCode.add(R.color.pink);
        colorCode.add(R.color.greenlight);
        colorCode.add(R.color.notgreen);

        Random randomColor = new Random();
        int number=randomColor.nextInt(colorCode.size());
        return colorCode.get(number);




    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView noteTitle,noteContent;
        View view;
        CardView mCardview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noteTitle=itemView.findViewById(R.id.titles);
            noteContent=itemView.findViewById(R.id.content);
            mCardview=itemView.findViewById(R.id.noteCard);
            view=itemView;

        }
    }
}
