package co.nimblehq.kmm.showcase.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import co.nimblehq.kmm.showcase.android.MainActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected val mainScope = MainScope()
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

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }
}
