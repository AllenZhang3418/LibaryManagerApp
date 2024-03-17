// ReturnBookActivity.kt
package package com.example.allen.liabaryManager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import  com.example.allen.liabaryManager.adapter.BookAdapter
import  com.example.allen.liabaryManager.model.Library
import  com.example.allen.liabaryManager.model.Book

class ReturnBookActivity : AppCompatActivity() {

    private lateinit var recyclerViewBooks: RecyclerView
    private lateinit var adapter: BookAdapter
    private lateinit var buttonReturnAll: Button
    private var borrowedBooks: List<Book> = emptyList() // Assuming this is a list of borrowed books obtained from somewhere

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_return_book)

        recyclerViewBooks = findViewById(R.id.recyclerViewBooks)
        buttonReturnAll = findViewById(R.id.buttonReturnAll)

        // Init RecyclerView
        recyclerViewBooks.layoutManager = LinearLayoutManager(this)
        adapter = BookAdapter(borrowedBooks) { book ->
            returnBook(book) // Process single book return logic
        }
        recyclerViewBooks.adapter = adapter

        // Initialize the click event of the return all book button
        buttonReturnAll.setOnClickListener {
            borrowedBooks.forEach { book ->
                returnBook(book) // Process all books return logic
            }
            // Assuming that after returning all the books, it is necessary to refresh the list or perform other operations
            adapter.notifyDataSetChanged() // Refresh List View
        }
    }

    // The function for executing the book return operation
    private fun returnBook(book: Book) {
        // Calling the ReturnBook method of the Library to return the book
        // Assuming that the Library is a singleton or an instance can be obtained in some way
        Library.getInstance().returnBook(book)
        // Handling UI updates or other logic after returning the book
    }
}