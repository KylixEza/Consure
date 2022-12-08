package com.bccxraion.consure.diff_callback

import com.bccxraion.consure.base.BaseDiffUtil
import com.bccxraion.consure.model.chat.Chat

class ChatDiffCallback(
    old: List<Chat>,
    new: List<Chat>
): BaseDiffUtil<Chat, String>(old, new) {
    override fun Chat.getItemIdentifier(): String = this.name
}