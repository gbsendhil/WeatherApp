package com.thoughtworks.weatherapp.detail

import android.accounts.NetworkErrorException
import com.nhaarman.mockito_kotlin.*
import com.thoughtworks.weatherapp.model.Main
import com.thoughtworks.weatherapp.model.WeatherInfo
import com.thoughtworks.weatherapp.model.Wind
import com.thoughtworks.weatherapp.network.WeatherService
import org.junit.Before
import org.junit.Test
import rx.Observable
import rx.schedulers.TestScheduler


class DetailPresenterTest {

  lateinit var presenter: DetailPresenter
  lateinit var view: DetailContract.View
  private lateinit var retrofitService: WeatherService
  private lateinit var testScheduler: TestScheduler
  private val weatherInfo = WeatherInfo(ArrayList(), Main(2.0, 1, 1, 2.0, 2.0), Wind(2.0, 1), 1, 1, "Bng")


  @Before
  fun setUp() {
    testScheduler = TestScheduler()
    view = mock { }
  }

  @Test
  fun shouldFetchWeather() {
    retrofitService = mock { on { getByCityName(any(), any(), any()) } doReturn Observable.just(weatherInfo) }
    presenter = DetailPresenter(view, retrofitService, testScheduler, testScheduler)
    presenter.fetchWeather()

    verify(retrofitService).getByCityName(eq("Bangalore"), any(), any())
    verify(view).showLoader()
    testScheduler.triggerActions()
    verify(view).updateWeather(weatherInfo)
    verify(view).hideLoader()
  }

  @Test
  fun shouldCatchNetworkError() {
    retrofitService = mock { on { getByCityName(any(), any(), any()) } doReturn Observable.error(NetworkErrorException()) }
    presenter = DetailPresenter(view, retrofitService, testScheduler, testScheduler)
    presenter.fetchWeather()

    verify(retrofitService).getByCityName(eq("Bangalore"), any(), any())
    verify(view).showLoader()
    testScheduler.triggerActions()
    verify(view).hideLoader()
    verify(view).showError("Network Unavailable")
  }
}
