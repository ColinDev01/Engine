package com.colindev.engine.di

import com.colindev.engine.TestData
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 *
 * @author Colin
 * @date 2023/3/30
 */
@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    fun provideTestData(): TestData {
        return TestData()
    }
}