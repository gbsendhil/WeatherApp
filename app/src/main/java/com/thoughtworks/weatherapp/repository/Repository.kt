package com.thoughtworks.weatherapp.repository

import android.content.Context
import com.thoughtworks.weatherapp.model.WeatherInfo
import com.thoughtworks.weatherapp.persistence.database.LocationDatabase
import com.thoughtworks.weatherapp.persistence.model.Location

class Repository {

  fun addLocation(context: Context, weatherInfo: WeatherInfo) {
    val location = createLocation(weatherInfo)
    val database = LocationDatabase.getDatabase(context)
    database?.locationModel()?.insert(location)
  }

  fun getLocationForCity(context: Context, city: String): Location? {
    val database = LocationDatabase.getDatabase(context)
    return database?.locationModel()?.getLocationForCity(city)
  }

  fun updateLocation(context: Context, weatherInfo: WeatherInfo) {
    val location = createLocation(weatherInfo)
    val database = LocationDatabase.getDatabase(context)
    database?.locationModel()?.update(location)
  }

  private fun createLocation(weatherInfo: WeatherInfo): Location {
    return Location(0,
        weatherInfo.name,
        weatherInfo.weather[0].icon,
        weatherInfo.dt,
        weatherInfo.main.temp,
        weatherInfo.weather[0].description,
        weatherInfo.main.pressure,
        weatherInfo.main.humidity)
  }

}