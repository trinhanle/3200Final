package com.example.k2024_03_19_basic_radio2.model

class RadioStations {

    fun getNextUrl() : String {
        currentUrl = (currentUrl+1) % urls.size
        return urls[currentUrl]
    }

    private val urls =  listOf(
        "http://playerservices.streamtheworld.com/api/livestream-redirect/WNPRFM.mp3",
        "http://stream.whus.org:8000/whusfm")

    private var currentUrl = 0

}