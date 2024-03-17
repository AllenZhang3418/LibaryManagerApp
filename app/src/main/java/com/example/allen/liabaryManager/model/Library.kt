package com.example.allen.liabaryManager.model

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.allen.liabaryManager.db.DatabaseHelper

class Library {
    private val books: MutableList<Book> = mutableListOf() // List of Library all books
    private val readers: MutableMap<String, Reader> = mutableMapOf() // Reader Information Mapping
    private val maxBooksPerReader = 6 // The maximum number of books that each reader can borrow at the same time
    private val maxBorrowPeriod = Period.ofMonths(3) // Maximum borrowing period for books

    // Initialize library books and readers information
    init {
        // Assuming that data for 1000 books and 50 readers has already been initialized here
        // Initial code omitted...
    }

    // Assumed book list
    private val books: MutableList<Book> = mutableListOf(
            Book("1", "Book1", "Author1", false),
            Book("2", "Book2", "Author2", false),
            // ... add more books info here
    )

    // Get all books
    fun getAllBooks(): List<Book> {
        return books
    }

    // Search for books based on titles
    fun searchBooksByTitle(title: String): List<Book> {
        return books.filter { it.title.contains(title, true) }
    }

    // Borrow book logic
    fun borrowBook(readerId: String, bookId: String): Boolean {
        // Check if readers exist, if the maximum number of borrowed books has been reached, and if the books have been lent out
        // ...
        // If the borrowing conditions are met, update the book and reader status
        // ...
        return true // Successful borrowing returns true, otherwise returns false
    }

    // Borrowing books sample code
    fun borrowBook_sample_code(bookId: String): Boolean {
        val bookToBorrow = books.find { it.id == bookId }
        if (bookToBorrow != null && !bookToBorrow.isBorrowed) {
            bookToBorrow.isBorrowed = true
            return true
        }
        return false
    }

    // Return book logic
    fun returnBook(readerId: String, bookId: String): Boolean {
        // Check reader and book information, update return status
        // ...
        // Check if there are any overdue books that have not been returned, and process the warning logic
        // ...
        return true // Successfully returning the book returns true, otherwise returns false
    }

    // Overdue warning logic
    fun checkOverdueBooks() {
        // Traverse all readers and books to check if there are any overdue books that have not been returned
        // ...
        // If it is found that the overdue book has not been returned, the reader's borrowing permission will be suspended and an alert will be issued
        // ...
    }

    // Other logics...

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var db: SQLiteDatabase

    init {
        dbHelper = DatabaseHelper(getApplication().getContext())
        db = dbHelper.writableDatabase
    }

    // Sample：add book
    fun addBook(book: Book) {
        val values = ContentValues()
        values.put("title", book.title)
        values.put("author", book.author)
        values.put("isbn", book.isbn)
        db.insert("books", null, values)
    }

    // sample：get all overdue books book and reader information
    fun getOverdueBooksWithReaders(): List<Pair<Book, Reader>> {
        val result = mutableListOf<Pair<Book, Reader>>()
        val cursor = db.query(
                "borrow_records INNER JOIN books ON borrow_records.book_id = books._id INNER JOIN readers ON borrow_records.reader_id = readers._id",
                arrayOf("books.*", "readers.*"),
                "strftime('%s', 'now') > strftime('%s', due_date)",
                null, null, null, null
        )

        if (cursor.moveToFirst()) {
            do {
                val book = Book(
                        cursor.getInt(cursor.getColumnIndex("_id")),
                        cursor.getString(cursor.getColumnIndex("title")),
                        cursor.getString(cursor.getColumnIndex("author")),
                        cursor.getString(cursor.getColumnIndex("isbn"))
                )
                val reader = Reader(
                        cursor.getInt(cursor.getColumnIndex("readers._id")),
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("email"))
                )
                result.add(Pair(book, reader))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return result
    }

    // ... Other database CRUD methods

}