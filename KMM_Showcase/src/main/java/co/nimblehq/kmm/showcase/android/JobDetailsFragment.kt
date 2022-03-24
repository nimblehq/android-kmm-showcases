package co.nimblehq.kmm.showcase.android

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.nimblehq.kmm.showcase.android.base.BaseFragment
import co.nimblehq.kmm.showcase.android.databinding.FragmentJobDetailsBinding
import co.nimblehq.kmm.showcase.data.RepositoryImpl
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class JobDetailsFragment : BaseFragment<FragmentJobDetailsBinding>() {

    private val mainScope = MainScope()
    private val repository = RepositoryImpl()

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
        mainScope.launch {
            kotlin.runCatching {
                repository.getJobDetails()
            }.onSuccess {
                binding.titleTv.text = it.message
            }.onFailure {
                binding.titleTv.text = it.localizedMessage
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
