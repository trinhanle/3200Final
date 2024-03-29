package com.example.k2024_02_28_affirmation_app.daa

import com.example.k2024_02_28_affirmation_app.model.Affirmation
import com.example.k2024_02_28_affirmation_app.R


class Datasource() {

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(1, R.string.affirmation1, R.drawable.image1),
            Affirmation(2, R.string.affirmation2, R.drawable.image2),
            Affirmation(3, R.string.affirmation3, R.drawable.image3),
            Affirmation(4, R.string.affirmation4, R.drawable.image4),
            Affirmation(5, R.string.affirmation5, R.drawable.image5),
            Affirmation(6, R.string.affirmation6, R.drawable.image6),
            Affirmation(7, R.string.affirmation7, R.drawable.image7),
            Affirmation(8, R.string.affirmation8, R.drawable.image8),
            Affirmation(9, R.string.affirmation9, R.drawable.image9),
            Affirmation(10, R.string.affirmation10, R.drawable.image10))
    }
}