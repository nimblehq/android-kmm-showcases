package co.nimblehq.kmm.showcase.domain

import co.nimblehq.kmm.showcase.data.JobDetail

data class JobDetailUiModel(
    val minimumPrice: String,
    val maximumPrice: String,
    val confirmedAt: Long?,
    val timeSlotStart: String,
    val timeSlotEnd: String,
    val plotSize: String,
    val plotAddress: String,
    val plotCropType: String,
    val message: String
)

fun JobDetail.toUiModel(): JobDetailUiModel {
    return JobDetailUiModel(
        minimumPrice = (this.minimumPrice ?: 0).toString(),
        maximumPrice = (this.maximumPrice ?: 0).toString(),
        confirmedAt = this.confirmedAt,
        timeSlotStart = this.timeSlot?.timeSlotStartAt.orEmpty(),
        timeSlotEnd = this.timeSlot?.timeSlotEndAt.orEmpty(),
        plotSize = (this.plot?.size ?: 0).toString(),
        plotAddress = this.plot?.address.orEmpty(),
        plotCropType = this.plot?.cropType.orEmpty(),
        message = this.message.orEmpty()
    )
}
