package com.colindev.engine.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.FragmentBinding
import com.dylanc.viewbinding.base.FragmentBindingDelegate
import org.greenrobot.eventbus.EventBus


/**
 *
 * @author Colin
 * @date 2023/3/30
 */
abstract class BaseFragment<VB : ViewBinding> : Fragment(), FragmentBinding<VB> by FragmentBindingDelegate() {

    open fun useEventBus(): Boolean {
        return false
    }

    abstract fun initView()

    abstract fun initData()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }
        return createViewWithBinding(inflater, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initView()
        initData()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (useEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }
}