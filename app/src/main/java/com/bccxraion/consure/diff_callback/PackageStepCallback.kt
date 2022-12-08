package com.bccxraion.consure.diff_callback

import com.bccxraion.consure.base.BaseDiffUtil

class PackageStepCallback(
    old: List<Int>,
    new: List<Int>
): BaseDiffUtil<Int, Int>(old, new) {
    override fun Int.getItemIdentifier(): Int = this
    
}