package com.bccxraion.consure.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListUpcomingSessionBinding
import com.bccxraion.consure.model.history.HistoryResponse

class UpcomingSessionAdapter: BaseRecyclerViewAdapter<ItemListUpcomingSessionBinding, HistoryResponse>() {
    override fun inflateViewBinding(parent: ViewGroup): ItemListUpcomingSessionBinding {
        return ItemListUpcomingSessionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val diffUtilBuilder: (List<HistoryResponse>, List<HistoryResponse>) -> DiffUtil.Callback?
        get() = TODO("Not yet implemented")
}