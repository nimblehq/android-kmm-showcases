package co.nimblehq.kmm.showcase.android

import android.os.Bundle
import android.view.*
import co.nimblehq.kmm.showcase.android.base.BaseFragment
import co.nimblehq.kmm.showcase.android.databinding.FragmentJobDetailsBinding

class JobDetailsFragment : BaseFragment<FragmentJobDetailsBinding>() {

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
    }
}
