package co.nimblehq.kmm.showcase.android

import android.os.Bundle
import android.view.*
import android.widget.Toast
import co.nimblehq.kmm.showcase.android.base.BaseFragment
import co.nimblehq.kmm.showcase.android.databinding.FragmentJobDetailsBinding
import co.nimblehq.kmm.showcase.android.extensions.formatDate
import co.nimblehq.kmm.showcase.domain.*
import kotlinx.coroutines.launch

class JobDetailsFragment : BaseFragment<FragmentJobDetailsBinding>() {

    private val getJobDetailUseCase: GetJobDetailUseCase = GetJobDetailUseCaseImpl()

    override fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): FragmentJobDetailsBinding {
        return FragmentJobDetailsBinding.inflate(layoutInflater, container, attachToParent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(R.string.job_details_title)

        binding.pbJobDetailsLoading.visibility = View.VISIBLE
        binding.clJobDetailsContainer.visibility = View.GONE
        mainScope.launch {
            kotlin.runCatching {
                getJobDetailUseCase.execute()
            }.onSuccess {
                displayJobDetails(it)
            }.onFailure {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun displayJobDetails(jobDetailUiModel: JobDetailUiModel) {
        with(binding) {
            pbJobDetailsLoading.visibility = View.GONE
            clJobDetailsContainer.visibility = View.VISIBLE
            with(jobDetailUiModel) {
                listOf(
                    tvJobDetailsPriceByAreaValue,
                    tvJobDetailsBottomPanelPriceValue
                ).forEach {
                    it.text = getString(
                        R.string.job_details_price_by_area_value,
                        minimumPrice,
                        maximumPrice
                    )
                }

                lJobDetailsDateTime.run {
                    tvJobDetailsDate.text = confirmedAt.formatDate()
                    tvJobDetailsTime.text =
                        getString(
                            R.string.job_details_date_time_time_value,
                            timeSlotStart,
                            timeSlotEnd
                        )
                }

                lJobDetailsPlotInfo.run {
                    tvJobDetailsPlotInfoSizeValue.text =
                        getString(R.string.job_details_plot_info_area_value, plotSize)
                    tvJobDetailsPlotInfoAddressValue.text = plotAddress
                    tvJobDetailsPlotInfoCropTypeValue.text = plotCropType
                }

                tvJobDetailMessageToPilotDescription.text = message
            }
        }
    }
}
