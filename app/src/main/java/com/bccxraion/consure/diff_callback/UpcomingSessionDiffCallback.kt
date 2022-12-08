package com.bccxraion.consure.diff_callback

import com.bccxraion.consure.base.BaseDiffUtil
import com.bccxraion.consure.model.history.History

class UpcomingSessionDiffCallback(
    old: List<History>,
    new: List<History>
): BaseDiffUtil<History, String>(old, new) {
    override fun History.getItemIdentifier(): String = this.transaction.id
}