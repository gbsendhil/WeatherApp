package com.thoughtworks.weatherapp.detail

import com.thoughtworks.weatherapp.network.WeatherService
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetailPresenter(
    private val view: DetailContract.View,
    private val retrofitService: WeatherService,
    private val processScheduler: Scheduler = Schedulers.io(),
    private val androidScheduler: Scheduler = AndroidSchedulers.mainThread()) : DetailContract.Presenter {

  override fun fetchWeather() {
    view.showLoader()

    retrofitService.getByCityName("Bangalore")
        .subscribeOn(processScheduler)
        .observeOn(androidScheduler)
        .subscribe(
            { weather ->
              view.updateWeather(weather)
              view.hideLoader()
            })

  }

}