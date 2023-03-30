package com.colindev.engine

import javax.inject.Inject


/**
 *
 * @author Colin
 * @date 2023/3/30
 */
class TestData @Inject constructor() {

    fun getData(): String {
        return "test"
    }
}