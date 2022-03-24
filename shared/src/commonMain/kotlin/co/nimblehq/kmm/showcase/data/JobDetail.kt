package co.nimblehq.kmm.showcase.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("data") val data: JobDetail
)

@Serializable
data class JobDetail(
    @SerialName("id") val id: String? = null,
    @SerialName("confirmed_at") val confirmedAt: Int? = null,
    @SerialName("created_at") val createdAt: Int? = null,
    @SerialName("expire_at") val expireAt: Int? = null,
    @SerialName("maximum_price") val maximumPrice: Int? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("minimum_price") val minimumPrice: Int? = null,
    @SerialName("proposed_at") val proposedAt: String? = null,
    @SerialName("status") val status: String? = null,
    @SerialName("updated_at") val updatedAt: Int? = null,
    @SerialName("farmer") val farmer: User? = User(),
    @SerialName("job_substance_type") val jobSubstanceType: JobSubstanceType? = JobSubstanceType(),
    @SerialName("plot") val plot: Plot? = Plot(),
    @SerialName("time_slot") val timeSlot: TimeSlot? = TimeSlot(),
    @SerialName("weather_forecast") val weatherForecast: WeatherForecast? = WeatherForecast()
)

@Serializable
data class User(
    @SerialName("id") val id: String? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("first_name") val firstName: String? = null,
    @SerialName("last_name") val lastName: String? = null,
    @SerialName("line_id") val lineId: String? = null,
    @SerialName("phone_number") val phoneNumber: String? = null,
    @SerialName("profile_picture") val profilePicture: String? = null
)

@Serializable
data class SubstanceType(
    @SerialName("id") val id: String? = null,
    @SerialName("icon_active_url") val iconActiveUrl: String? = null,
    @SerialName("icon_inactive_url") val iconInactiveUrl: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("slug") val slug: String? = null
)

@Serializable
data class JobSubstanceType(
    @SerialName("id") val id: String? = null,
    @SerialName("has_substance") val hasSubstance: Boolean? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("substance_type") val substanceType: SubstanceType? = SubstanceType()
)

@Serializable
data class Region(
    @SerialName("id") val id: String? = null,
    @SerialName("maximum_price") val maximumPrice: Int? = null,
    @SerialName("minimum_price") val minimumPrice: Int? = null,
    @SerialName("name") val name: String? = null
)

@Serializable
data class Plot(
    @SerialName("id") val id: String? = null,
    @SerialName("address") val address: String? = null,
    @SerialName("created_at") val createdAt: Int? = null,
    @SerialName("crop_type") val cropType: String? = null,
    @SerialName("latitude") val latitude: String? = null,
    @SerialName("longitude") val longitude: String? = null,
    @SerialName("message") val message: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("region_id") val regionId: String? = null,
    @SerialName("size") val size: Int? = null,
    @SerialName("region") val region: Region? = Region()
)

@Serializable
data class TimeSlot(
    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("time_slot_end_at") val timeSlotEndAt: String? = null,
    @SerialName("time_slot_start_at") val timeSlotStartAt: String? = null
)

@Serializable
data class WeatherForecast(
    @SerialName("id") val id: String? = null,
    @SerialName("chance_of_rain") val chanceOfRain: Int? = null,
    @SerialName("created_at") val createdAt: Int? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("icon_2x_url") val icon2xUrl: String? = null,
    @SerialName("icon_url") val iconUrl: String? = null
)
