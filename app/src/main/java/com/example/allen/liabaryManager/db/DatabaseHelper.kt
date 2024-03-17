// DatabaseHelper.kt

package com.example.allen.liabaryManager.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.annotation.Nullable

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private static final int DATABASE_VERSION = 1
    private static final String DATABASE_NAME = "library_db.db"

    override fun onCreate(db: SQLiteDatabase) {
        // Create table
        db.execSQL("CREATE TABLE books (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, author TEXT, isbn TEXT)")
        db.execSQL("CREATE TABLE readers (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)")
        db.execSQL("CREATE TABLE borrow_records (_id INTEGER PRIMARY KEY AUTOINCREMENT, book_id INTEGER, reader_id INTEGER, borrow_date TEXT, due_date TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Processing logic during database version upgrade
        db.execSQL("DROP TABLE IF EXISTS books")
        db.execSQL("DROP TABLE IF EXISTS readers")
        db.execSQL("DROP TABLE IF EXISTS borrow_records")
        onCreate(db)
    }
}