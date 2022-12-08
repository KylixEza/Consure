package com.bccxraion.consure.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListUpcomingSessionBinding
import com.bccxraion.consure.diff_callback.UpcomingSessionDiffCallback
import com.bccxraion.consure.model.history.History
import com.bumptech.glide.Glide
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class UpcomingSessionAdapter: BaseRecyclerViewAdapter<ItemListUpcomingSessionBinding, History>() {
    override fun inflateViewBinding(parent: ViewGroup): ItemListUpcomingSessionBinding {
        return ItemListUpcomingSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val binder: (History, ItemListUpcomingSessionBinding) -> Unit
        @RequiresApi(Build.VERSION_CODES.O)
        get() = { data, binding ->
            binding.apply {
                Glide.with(itemView.context)
                    .load(data.expert.linkImage)
                    .into(binding.ivAvatar)
                tvName.text = data.expert.name
                tvTag.text = data.expert.tag
    
                val formatter = DateTimeFormatter.ofPattern("EEEE dd/MM/yyyy HH:mm", Locale.ENGLISH)
                val date = LocalDateTime.parse(data.transaction.schedule, formatter)
    
                val schedule = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH.mm"))
                tvSchedule.text = schedule
            }
        }
    
    override val diffUtilBuilder: (List<History>, List<History>) -> DiffUtil.Callback?
        get() = { old, new -> UpcomingSessionDiffCallback(old, new) }
}