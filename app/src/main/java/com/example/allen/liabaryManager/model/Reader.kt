package com.example.allen.liabaryManager.model

data class Reader(
        val id: String, // Reader uniqe ID string
        val name: String, // Reader name
        val borrowedBooks: MutableList<Book> = mutableListOf() // The reader current borrrowed books list
)