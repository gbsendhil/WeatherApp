package com.thoughtworks.weatherapp.detail

import com.thoughtworks.weatherapp.model.WeatherInfo

interface DetailContract {
  interface View {
    fun updateWeather(weatherInfo: WeatherInfo)
    fun showLoader()
    fun hideLoader()
    fun showError(message: String)
  }

  interface Presenter {
    fun fetchWeather()
  }
}