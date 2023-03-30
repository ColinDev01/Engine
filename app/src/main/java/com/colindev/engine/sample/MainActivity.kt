package com.colindev.engine.sample

import com.colindev.engine.TestData
import com.colindev.engine.base.BaseActivity
import com.colindev.engine.sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject lateinit var testData: TestData

    override fun initView() {
        binding.tvContent.text = testData.getData()
    }

    override fun initData() {

    }
}