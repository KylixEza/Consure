package com.bccxraion.consure.diff_callback

import com.bccxraion.consure.base.BaseDiffUtil
import com.bccxraion.consure.model.expert.Expert

class FindExpertCallback(
    old: List<Expert>,
    new: List<Expert>
): BaseDiffUtil<Expert, String>(old, new) {
    override fun Expert.getItemIdentifier(): String = this.id
}