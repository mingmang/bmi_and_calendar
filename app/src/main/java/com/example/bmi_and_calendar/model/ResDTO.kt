package com.example.bmi_and_calendar.model

import android.icu.text.CaseMap
import com.google.gson.annotations.SerializedName


data class ResDTO(
        @SerializedName("item") val restaurants : List<Restaurant>
) {}