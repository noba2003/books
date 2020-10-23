
package com.example.books.recycileview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.books.MainActivity;
import com.example.books.R;
import com.example.books.loginActivity;

import java.util.List;

public class adapterCourse extends RecyclerView.Adapter<adapterCourse.holde>  {
    List<item> courses;
    Context context;
    private callbackSendData callbackSendData;

    public adapterCourse() {
    }

    public adapterCourse(List<item> lessons,Context context ,callbackSendData callbackSendData) {
        this.courses = lessons;
        this.context = context;
        this.callbackSendData = callbackSendData;
    }

    @NonNull
    @Override
    public holde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false);
        return new holde(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holde holder, int position) {
        item lessonitem = courses.get(position);
        holder.author.setText(lessonitem.getAuthor());
        holder.lrssonTitle.setText(lessonitem.getLessonTiltle());
        holder.ratingBar.setRating(lessonitem.getRatingBar());
        holder.imglesson.setImageResource(lessonitem.getImgLesson());
        holder.datelesson.setText(lessonitem.getDateLesson() + "");

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
callbackSendData.sendDataToActiviat(position);
    }
});

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }



    public class holde extends RecyclerView.ViewHolder {
        ImageView imglesson;
        TextView lrssonTitle, author, datelesson;
        RatingBar ratingBar;


        public holde(@NonNull View itemView) {
            super(itemView);
            imglesson = itemView.findViewById(R.id.img_book);
            lrssonTitle = itemView.findViewById(R.id.book_title);
            author = itemView.findViewById(R.id.author_book);
            datelesson = itemView.findViewById(R.id.book_year);
            ratingBar = itemView.findViewById(R.id.rating);

    }}
}
