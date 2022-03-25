package co.nimblehq.kmm.showcase.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.nimblehq.kmm.showcase.android.base.BaseFragment
import co.nimblehq.kmm.showcase.android.databinding.FragmentJobDetailsBinding
import co.nimblehq.kmm.showcase.domain.GetJobDetailUseCase
import co.nimblehq.kmm.showcase.domain.GetJobDetailUseCaseImpl
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

        // TODO Display response in integration task
        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_SHORT).show()
        mainScope.launch {
            kotlin.runCatching {
                getJobDetailUseCase.execute()
            }.onSuccess {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }.onFailure {
                Toast.makeText(requireContext(), it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
