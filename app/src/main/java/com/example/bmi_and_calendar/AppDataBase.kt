package com.example.bmi_and_calendar

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bmi_and_calendar.Dao.HistoryDao
import com.example.bmi_and_calendar.Dao.ReviewDao
import com.example.bmi_and_calendar.model.History
import com.example.bmi_and_calendar.model.Review

@Database(entities = [History::class, Review::class], version=1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun historyDao() : HistoryDao
    abstract fun reviewDao() : ReviewDao
}