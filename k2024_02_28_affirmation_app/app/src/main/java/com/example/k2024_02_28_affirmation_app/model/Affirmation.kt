package com.example.k2024_02_28_affirmation_app.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation (
    @StringRes val stringResourceID: Int,
    @DrawableRes val imageResourceID: Int
)
