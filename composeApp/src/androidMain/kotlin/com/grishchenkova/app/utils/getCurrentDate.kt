package com.grishchenkova.app.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
actual fun getCurrentDate(): String {
    val currentDate = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("d MMMM", Locale.US)
    return currentDate.format(formatter)
}