package com.example.k2024_04_02_basicrest_calls.models


data class ImageData (
    var title: String,
    var author: String,
    var type: String
)

data class Images (
    var imagesMetaData: List<ImageData>
)