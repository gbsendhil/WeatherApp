package com.thoughtworks.weatherapp.detail

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import com.nhaarman.mockito_kotlin.*
import com.thoughtworks.weatherapp.network.WeatherService


class DetailPresenterTest{

    lateinit var presenter: DetailPresenter
    lateinit var view: DetailView
    lateinit var weatherService: WeatherService

    @Before
    fun setUp() {
        view = mock {  }
        weatherService = mock {  }
        presenter = DetailPresenter(view, weatherService)
    }

    @Test
    fun shouldFetchWeather() {
        presenter.fetchWeather()

        val subscription = verify(weatherService).getByCityName("Bangalore")
        verify(view).updateWeather()
    }
}
