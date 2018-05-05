package com.thoughtworks.weatherapp.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.thoughtworks.weatherapp.R
import com.thoughtworks.weatherapp.model.WeatherInfo
import com.thoughtworks.weatherapp.network.WeatherService
import kotlinx.android.synthetic.main.activity_main.*

class DetailActivity : AppCompatActivity(), DetailContract.View {

  private lateinit var presenter: DetailPresenter
  private val weatherService: WeatherService = WeatherService.Client.instance()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    presenter = DetailPresenter(this, weatherService)
    presenter.fetchWeather()
  }

  override fun showLoader() {
    loader.visibility = View.VISIBLE
  }

  override fun hideLoader() {
    loader.visibility = View.GONE
  }

  override fun showError(message: String) {
    error.visibility = View.VISIBLE
    error.text = message
  }

  override fun updateWeather(weatherInfo: WeatherInfo) {
    city.text = weatherInfo.name
    temperature.text = weatherInfo.main.temp.toString()
    description.text = weatherInfo.weather[0].description
    pressure.text = weatherInfo.main.pressure.toString()
    humidity.text = weatherInfo.main.humidity.toString()
    weather_date.text = weatherInfo.dt.toString()
  }
}
