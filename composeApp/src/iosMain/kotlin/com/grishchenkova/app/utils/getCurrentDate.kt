package com.grishchenkova.app.utils

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale

actual fun getCurrentDate(): String {
    val currentDate = NSDate()
    val dateFormatter = NSDateFormatter().apply {
        dateFormat = "d MMMM"
        locale = NSLocale(localeIdentifier = "en")
    }
    return dateFormatter.stringFromDate(currentDate)
}