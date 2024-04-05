package com.example.k2024_04_01_video_direct_mp4.models

import android.net.Uri

data class MetaData(
    val fileName: String
)

interface MedaDataReader {
    fun getMetaDataFromUri(contentUri: Uri) : MetaData
}

class MetaDataReaderImpl(

)