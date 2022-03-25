package co.nimblehq.kmm.showcase.android.extensions

import java.text.SimpleDateFormat
import java.util.*

const val JOB_DETAILS_DATE_FORMAT = "dd MMM yyyy"

fun Long?.formatDate(dateFormat: String = JOB_DETAILS_DATE_FORMAT): String {
    return this?.let {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        val calendar = Calendar.getInstance()

        calendar.timeInMillis = this
        formatter.format(calendar.time)
    } ?: ""
}
