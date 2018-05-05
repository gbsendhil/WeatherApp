package com.thoughtworks.weatherapp.persistence.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.thoughtworks.cityapp.persistence.dao.LocationDao
import com.thoughtworks.weatherapp.persistence.model.Location

@Database(entities = [Location::class], version = 1)
abstract class LocationDatabase : RoomDatabase() {

  abstract fun locationModel(): LocationDao

  companion object {
    private var INSTANCE: LocationDatabase? = null

    fun getDatabase(context: Context): LocationDatabase? {
      if (INSTANCE == null) {
        synchronized(LocationDatabase::class) {
          INSTANCE = Room.databaseBuilder(context.applicationContext,
              LocationDatabase::class.java,
              "weather.db")
              .build()
        }
      }
      return INSTANCE
    }
  }

}