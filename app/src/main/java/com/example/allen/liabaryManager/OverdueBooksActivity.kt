// OverdueBooksActivity.kt
package package com.example.allen.liabaryManager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.allen.liabaryManager.adapter.OverdueBookAdapter
import com.example.allen.liabaryManager.model.Book
import com.example.allen.liabaryManager.model.Reader
import com.example.allen.liabaryManager.model.Library

class OverdueBooksActivity : AppCompatActivity() {

    private lateinit var recyclerViewOverdueBooks: RecyclerView
    private lateinit var adapter: OverdueBookAdapter
    private lateinit var buttonSendWarnings: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overdue_books)

        recyclerViewOverdueBooks = findViewById(R.id.recyclerViewOverdueBooks)
        buttonSendWarnings = findViewById(R.id.buttonSendWarnings)

        // Set up the layout manager for RecyclerView
        recyclerViewOverdueBooks.layoutManager = LinearLayoutManager(this)

        // Initialize adapter (assuming the adapter accepts an empty list, data will be updated later)
        adapter = OverdueBookAdapter(emptyList()) { overdueBook, reader ->
            sendWarning(overdueBook, reader)
        }
        recyclerViewOverdueBooks.adapter = adapter

        // Set the click event for the send alert button
        buttonSendWarnings.setOnClickListener {
            // Assuming the getOverdueBooksWithReader() method returns a list of overdue books and corresponding readers
            val overdueBooksWithReaders = Library.getInstance().getOverdueBooksWithReaders()
            overdueBooksWithReaders.forEach { (book, reader) ->
                sendWarning(book, reader)
            }
            Toast.makeText(this, "Warning msg has sent", Toast.LENGTH_SHORT).show()
        }

        // Load and display overdue book list
        loadAndShowOverdueBooks()
    }

    // Load and display overdue book list
    private fun loadAndShowOverdueBooks() {
        // Assuming the getOverdueBooksWithReader() method returns a list of overdue books and corresponding readers
        val overdueBooksWithReaders = Library.getInstance().getOverdueBooksWithReaders()
        adapter.submitList(overdueBooksWithReaders) // Update list data using submitList
    }

    // The function for sending warning notifications (here is just an example, you need to implement the sending logic according to the actual situation)
    private fun sendWarning(book: Book, reader: Reader) {
        // TODO: Implement the logic of sending emails or notifications
        // For example, you can call a service to send emails or notifications
        // sendEmail(reader.email, "Book return overdue reminder", "Your book ${book.title} has overdue, need return it back as soon as possible.")
        // sendNotification(reader.deviceId, "Book return overdue reminder", "Your book ${book.title} has overdue")
    }
}