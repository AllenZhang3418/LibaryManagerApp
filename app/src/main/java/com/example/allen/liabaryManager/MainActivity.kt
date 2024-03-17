package com.example.allen.liabaryManager

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.* // Kotlinx Android Extensions
// Or can use View Binding
// import com.example.allen.liabaryManager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // can use View Binding
    // private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // use iew Binding to initialize layout
        // binding = ActivityMainBinding.inflate(layoutInflater)
        // setContentView(binding.root)

        // Assuming there is some basic information, here is just a simple example
        val totalBooks = 1000
        val totalReaders = 50
        val maxBooksPerReader = 6

        // Update UI elements to display basic information
        totalBooksTextView.text = "Total Books: $totalBooks"
        totalReadersTextView.text = "Total Readers: $totalReaders"
        maxBooksPerReaderTextView.text = "Max Books Per Reader: $maxBooksPerReader"

        // Set button click event listener
        borrowBookButton.setOnClickListener {
            // jump to borrow book page
            val intent = Intent(this, BorrowBookActivity::class.java)
            startActivity(intent)
        }

        returnBookButton.setOnClickListener {
            // jump to return book page
            val intent = Intent(this, ReturnBookActivity::class.java)
            startActivity(intent)
        }

        viewOverdueBooksButton.setOnClickListener {
            // jump to check return book overdue manager page
            val intent = Intent(this, OverdueBooksActivity::class.java)
            startActivity(intent)
        }
    }
}