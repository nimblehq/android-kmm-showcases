package co.nimblehq.kmm.showcase.android.base

import android.os.Bundle
import android.view.*
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import co.nimblehq.kmm.showcase.android.MainActivity

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    private var _binding: ViewBinding? = null

    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    abstract fun getViewBinding(
        layoutInflater: LayoutInflater,
        container: ViewGroup?,
        attachToParent: Boolean
    ): VB

    fun setupToolbar(@StringRes titleRes: Int) {
        (activity as MainActivity).supportActionBar?.title = getString(titleRes)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return getViewBinding(inflater, container, false).apply {
            _binding = this
        }.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
