package com.bccxraion.consure.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListDummyPostBinding
import com.bccxraion.consure.diff_callback.PostDiffCallback
import com.bccxraion.consure.features.detail_post.DetailPostActivity

class PostAdapter: BaseRecyclerViewAdapter<ItemListDummyPostBinding, Int>() {
    override fun inflateViewBinding(parent: ViewGroup): ItemListDummyPostBinding {
        return ItemListDummyPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val binder: (Int, ItemListDummyPostBinding) -> Unit
        get() = { item, binding ->
            binding.ivImage.setImageResource(item)
            
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, DetailPostActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    
    override val diffUtilBuilder: (List<Int>, List<Int>) -> DiffUtil.Callback?
        get() = { old, new -> PostDiffCallback(old, new) }
}