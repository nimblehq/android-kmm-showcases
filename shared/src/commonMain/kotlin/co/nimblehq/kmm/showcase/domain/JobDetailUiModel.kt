package co.nimblehq.kmm.showcase.domain

import co.nimblehq.kmm.showcase.data.JobDetail

data class JobDetailUiModel(
    val minimumPrice: Int,
    val maximumPrice: Int,
    val confirmedAt: String,
    val timeSlotStart: String,
    val timeSlotEnd: String,
    val plotSize: Int,
    val plotAddress: String,
    val plotCropType: String,
    val message: String
)

fun JobDetail.toUiModel(): JobDetailUiModel {
    return JobDetailUiModel(
        minimumPrice = this.minimumPrice ?: 0,
        maximumPrice = this.maximumPrice ?: 0,
        confirmedAt = this.confirmedAt.toString(), // TODO Create extension to parse to date time
        timeSlotStart = this.timeSlot?.timeSlotStartAt.orEmpty(),
        timeSlotEnd = this.timeSlot?.timeSlotEndAt.orEmpty(),
        plotSize = this.plot?.size ?: 0,
        plotAddress = this.plot?.address.orEmpty(),
        plotCropType = this.plot?.cropType.orEmpty(),
        message = this.message.orEmpty()
    )
}