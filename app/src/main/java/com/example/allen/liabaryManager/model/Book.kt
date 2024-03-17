package com.example.allen.liabaryManager.model

static class Book{
    val id: String, // Unique identification ID of the book
    val title: String, // Book titles
    val author: String, // author
    val isBorrowed: Boolean = false, // Has it been borrowed
    val borrowerId: String? = null, // Borrower ID, null if not been borrowed
    val borrowDate: LocalDate? = null, // Borrowing date, null if not been borrowed
    val returnDate: LocalDate? = null // Return date, null if not returned

    // ... Other fields and constructors, getters, setters, etc ...

    fun getTitle():String {
        return title
    }

    fun setTitle(title: String) {
        this.title = title
    }

    fun getDueDate(): String {
        return dueDate
    }

    fun setDueDate(dueDate: String) {
        this.dueDate = dueDate
    }

    // ... Other methods ...
}