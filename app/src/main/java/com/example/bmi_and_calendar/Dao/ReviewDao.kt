package com.example.bmi_and_calendar.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import com.example.bmi_and_calendar.model.Review

@Dao
interface ReviewDao {

    @Query("SELECT * FROM review WHERE id == :id")
    fun getOnReview(id:Int): Review

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveReview(review:Review)
}