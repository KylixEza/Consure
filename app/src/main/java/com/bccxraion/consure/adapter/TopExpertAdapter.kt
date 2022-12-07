package com.bccxraion.consure.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListDummyExpertHorizontalBinding
import com.bccxraion.consure.diff_callback.TopExpertDiffCallback

class TopExpertAdapter: BaseRecyclerViewAdapter<ItemListDummyExpertHorizontalBinding, Int>() {
    override fun inflateViewBinding(parent: ViewGroup): ItemListDummyExpertHorizontalBinding {
        return ItemListDummyExpertHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val binder: (Int, ItemListDummyExpertHorizontalBinding) -> Unit
        get() = { data, binding ->
            binding.ivImage.setImageResource(data)
        }
    
    override val diffUtilBuilder: (List<Int>, List<Int>) -> DiffUtil.Callback?
        get() = { old, new -> TopExpertDiffCallback(old, new) }
}