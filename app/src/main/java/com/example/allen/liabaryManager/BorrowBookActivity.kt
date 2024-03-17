// BorrowBookActivity.kt
package com.example.allen.liabaryManager

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.RecyclerView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager

class BorrowBookActivity : AppCompatActivity() {

    private lateinit var recyclerViewBooks: RecyclerView
    private lateinit var editTextSearch: EditText
    private lateinit var adapter: BookAdapter
    private var books: List<Book> = listOf() // assume "Book" are our book data model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_borrow_book)

        // Initialize View Components
        recyclerViewBooks = findViewById(R.id.recyclerViewBooks)
        editTextSearch = findViewById(R.id.editTextSearch)

        //Initialize the adapter and set it to RecyclerView
        books = fetchBooksFromLibrary() // This should be a method to obtain a list of books, and you need to implement it according to the actual situation
        adapter = BookAdapter(books) { book ->
            showBorrowBookDialog(book)
        }
        recyclerViewBooks.layoutManager = LinearLayoutManager(this)
        recyclerViewBooks.adapter = adapter

        // Set the click event for the search button
        findViewById<View>(R.id.buttonSearch).setOnClickListener {
            val query = editTextSearch.text.toString()
            val filteredBooks = books.filter { it.title.contains(query, ignoreCase = true) }
            adapter.updateBooks(filteredBooks)
        }
    }

    // The hypothetical method for obtaining a book list needs to be implemented according to the actual situation
    private fun fetchBooksFromLibrary(): List<Library.Book> {
        // This should be the code for obtaining the book list from a database or network API
        // This is just returning an example list
        return listOf(
                Library.Book("Book1", "Author1"),
                Library.Book("Book2", "Author2"),
                // ...other books infor
        )
    }

    // Display borrowing dialog box
    private fun showBorrowBookDialog(book: Library.Book) {
        AlertDialog.Builder(this)
                .setTitle("Borrow book")
                .setMessage("Are you sure you want to borrow this book?")
                .setPositiveButton("Confirm", DialogInterface.OnClickListener { _, _ ->
                    // Implement the logic of borrowing books here, such as updating the borrowing status of books or sending requests to the server
                    Toast.makeText(this, "Borrowed successfully：${book.title}", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Cancel", null)
                .show()
    }

    // BookAdapter's update book list method
    class BookAdapter(private val books: List<Book>, private val onBookBorrowed: (Book) -> Unit) :
            RecyclerView.Adapter<BookAdapter.ViewHolder>() {

        // ViewHolder、onBindViewHolder and so on. Just omitting the implementation of these methods...
        // ...

        //Update book list
        fun updateBooks(newBooks: List<Book>) {
            this.books = newBooks
            notifyDataSetChanged()
        }
    }
}