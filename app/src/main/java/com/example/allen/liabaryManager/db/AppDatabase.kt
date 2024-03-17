package com.example.allen.liabaryManager.db

import com.example.allen.liabaryManager.db.RoomDatabase
import com.example.allen.liabaryManager.db.BookDao

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao

    // Create a single instance of the database
    private static var INSTANCE: AppDatabase? = null

    static fun getDatabase(context: Context): AppDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(AppDatabase::class.java) {
            val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "library_db.db" // The database file name is specified here
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}