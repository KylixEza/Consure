package com.bccxraion.consure.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListChatBinding
import com.bccxraion.consure.diff_callback.ChatDiffCallback
import com.bccxraion.consure.features.expert_talk.DetailExpertTalkActivity
import com.bccxraion.consure.model.chat.Chat

class ChatAdapter: BaseRecyclerViewAdapter<ItemListChatBinding, Chat>() {
    override fun inflateViewBinding(parent: ViewGroup): ItemListChatBinding {
        return ItemListChatBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val binder: (Chat, ItemListChatBinding) -> Unit
        get() = { data, binding ->
            binding.apply {
                ivAvatar.setImageResource(data.avatar)
                tvName.text = data.name
                tvPreviewChat.text = data.message
                tvTime.text = data.time
                if (data.isRead) {
                    ivUnread.visibility = android.view.View.INVISIBLE
                    tvTime.setTextColor(itemView.resources.getColor(R.color.font_disable_2))
                } else {
                    ivUnread.visibility = android.view.View.VISIBLE
                    tvTime.setTextColor(itemView.resources.getColor(R.color.green))
                }
            }
            
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailExpertTalkActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    
    override val diffUtilBuilder: (List<Chat>, List<Chat>) -> DiffUtil.Callback?
        get() = { old, new -> ChatDiffCallback(old, new) }
}