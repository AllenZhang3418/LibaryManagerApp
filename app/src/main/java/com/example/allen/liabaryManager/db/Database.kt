package com.example.allen.liabaryManager.db

import com.example.allen.liabaryManager.db.RoomDatabase
import com.example.allen.liabaryManager.db.BookDao

@Database(entities = [Book::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}