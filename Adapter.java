package com.aybukefirat.bookmyapp.model;

import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aybukefirat.bookmyapp.BookDetails;
import com.aybukefirat.bookmyapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<Adapter.Viewholder> {
   List<String> titles;
   List<String> content;

   public Adapter(List<String> title, List<String> content){
       this.titles=title;
       this.content=content;


   }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate( R.layout.book_view_layout, parent,false);
        return new Viewholder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
       holder.bookTitle.setText(titles.get(position));
       holder.bookContent.setText(content.get(position));
       Integer code =getRandomColor();
       holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(code,null));

       holder.view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(v.getContext(), BookDetails.class);
               i.putExtra("title",titles.get(position));
               i.putExtra("content",content.get(position));
               i.putExtra("code",code);
               v.getContext().startActivity(i);


           }
       });

    }

    private int getRandomColor() {
       List<Integer> colorCode= new ArrayList<>();
       colorCode.add(R.color.colorAccent);
        colorCode.add(R.color.yellow);
        colorCode.add(R.color.lightGreen);
        colorCode.add(R.color.pink);
        colorCode.add(R.color.lightPurple);
        colorCode.add(R.color.skyblue);
        colorCode.add(R.color.gray);
        colorCode.add(R.color.greenlight);
        colorCode.add(R.color.notgreen);

        Random randomColor= new Random();
        int number = randomColor.nextInt(colorCode.size());
        return colorCode.get(number);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
       TextView bookTitle,bookContent;
       View view;
       CardView mCardView;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            bookTitle=itemView.findViewById(R.id.titles);
            bookContent=itemView.findViewById(R.id.content);
            mCardView= itemView.findViewById(R.id.BookCard);
            view=itemView;
        }

        public Viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
