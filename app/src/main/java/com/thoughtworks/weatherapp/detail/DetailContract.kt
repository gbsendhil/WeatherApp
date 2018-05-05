package com.thoughtworks.weatherapp.detail

import com.thoughtworks.weatherapp.model.WeatherInfo

interface DetailContract {
  interface View {
    fun updateWeather(weatherInfo: WeatherInfo)
    fun showLoader()
    fun hideLoader()
  }

  interface Presenter {
    fun fetchWeather()
  }
}