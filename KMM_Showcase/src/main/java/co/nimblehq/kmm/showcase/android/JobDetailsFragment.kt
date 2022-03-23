package co.nimblehq.kmm.showcase.android

import android.os.Bundle
import android.view.*
import android.widget.Toast
import co.nimblehq.kmm.showcase.Api
import co.nimblehq.kmm.showcase.android.base.BaseFragment
import co.nimblehq.kmm.showcase.android.databinding.FragmentJobDetailsBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class JobDetailsFragment : BaseFragment<FragmentJobDetailsBinding>() {

    private val mainScope = MainScope()
    private val api = Api()

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

        mainScope.launch {
            kotlin.runCatching {
                api.todoTask()
            }.onSuccess {
                binding.titleTv.text = it
            }.onFailure {
                binding.titleTv.text = it.localizedMessage
            }

            Toast.makeText(requireContext(), "hello2", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
