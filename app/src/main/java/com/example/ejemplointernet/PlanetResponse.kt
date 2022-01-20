package com.example.ejemplointernet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class PlanetResponse (
    val count: Long,
    val next: String,
    val results: List<Planet>
) : Parcelable
