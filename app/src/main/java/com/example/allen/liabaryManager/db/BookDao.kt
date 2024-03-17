// BookDao.kt

package com.example.allen.liabaryManager.db

import androidx.room.*

@Dao
interface BookDao {
    // Define the data access method ,such as
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(book: Book)

    @Update
    fun update(book: Book)

    @Delete
    fun delete(book: Book)

    @Query("SELECT * FROM books")
    fun getAllBooks(): List<Book>

    // Other database query methods...
}