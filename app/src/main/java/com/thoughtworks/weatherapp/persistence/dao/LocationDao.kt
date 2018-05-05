package com.thoughtworks.cityapp.persistence.dao

import android.arch.persistence.room.*
import com.thoughtworks.weatherapp.persistence.model.Location

@Dao
interface LocationDao {

  @Query("Select * from location")
  fun getAll(): List<Location>

  @Query("Select * from location where name like :city")
  fun getLocationForCity(city: String): Location

  @Insert
  fun insert(city: Location)

  @Update(onConflict = OnConflictStrategy.REPLACE)
  fun update(city: Location)
}