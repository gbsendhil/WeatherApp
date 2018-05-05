package com.thoughtworks.weatherapp.persistence.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "location")
data class Location(@PrimaryKey(autoGenerate = true)
                    @ColumnInfo(name = "location_id")
                    var id: Long?,
                    @ColumnInfo(name = "name")
                    var name: String,
                    @ColumnInfo(name = "icon")
                    var icon: String,
                    @ColumnInfo(name = "date")
                    var date: Long,
                    @ColumnInfo(name = "temperature")
                    var temperature: Double,
                    @ColumnInfo(name = "description")
                    var description: String,
                    @ColumnInfo(name = "pressure")
                    var pressure: Int,
                    @ColumnInfo(name = "humidity")
                    var humidity: Int) {
}