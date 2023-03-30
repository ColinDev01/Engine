package com.colindev.engine.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.base.ActivityBinding
import com.dylanc.viewbinding.base.ActivityBindingDelegate
import com.gyf.immersionbar.ktx.immersionBar
import org.greenrobot.eventbus.EventBus


/**
 *
 * @author Colin
 * @date 2023/3/30
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity(), ActivityBinding<VB> by ActivityBindingDelegate() {

    open fun useEventBus(): Boolean {
        return false
    }

    abstract fun initView()

    abstract fun initData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentViewWithBinding()

        if (useEventBus()) {
            EventBus.getDefault().register(this)
        }

        initView()
        initData()
    }

    protected fun setStatusBar(
        view: View,
        isDarkFont: Boolean = true,
        statusAlpha: Float = 0.8f
    ) {
        immersionBar {
            statusBarDarkFont(isDarkFont, statusAlpha)
            statusBarView(view)
        }
    }

    override fun onDestroy() {
        if (useEventBus() && EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
        super.onDestroy()
    }

}