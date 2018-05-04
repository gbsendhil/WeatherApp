package com.thoughtworks.weatherapp.detail

import com.thoughtworks.weatherapp.network.WeatherService
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class DetailPresenter(val view: DetailView, val weatherService: WeatherService) {
    fun fetchWeather() {
        weatherService.getByCityName("Bangalore")
                .subscribeOn(Schedulers.newThread())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ weather -> view.updateWeather()},
                        {t: Throwable? ->  })

    }

}