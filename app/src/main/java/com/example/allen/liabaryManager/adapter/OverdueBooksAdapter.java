// OverdueBooksAdapter.java
package com.example.allen.liabaryManager.adapter

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.allen.liabaryManager.model.Book;

import java.util.List;

public class OverdueBooksAdapter extends RecyclerView.Adapter<OverdueBooksAdapter.ViewHolder> {

    private Context context;
    private List<Book> overdueBooks;

    public OverdueBooksAdapter(Context context, List<Book> overdueBooks) {
        this.context = context;
        this.overdueBooks = overdueBooks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.overdue_book_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = overdueBooks.get(position);
        holder.tvBookTitle.setText(book.getTitle());
        holder.tvDueDate.setText(book.getDueDate()); // Assuming the Book class has a getDueDate() method that returns the expected return date
        // Depending on whether the book is overdue, the background color or other properties of the view can be set
    }

    @Override
    public int getItemCount() {
        return overdueBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBookTitle;
        TextView tvDueDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBookTitle = itemView.findViewById(R.id.tvBookTitle);
            tvDueDate = itemView.findViewById(R.id.tvDueDate);
        }
    }
}