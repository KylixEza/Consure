package com.bccxraion.consure.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseRecyclerViewAdapter
import com.bccxraion.consure.databinding.ItemListFindExpertBinding
import com.bccxraion.consure.diff_callback.FindExpertDiffCallback
import com.bccxraion.consure.features.detail_find_expert.DetailFindExpertActivity
import com.bccxraion.consure.model.expert.Expert
import com.bccxraion.consure.util.Formatting
import com.bccxraion.consure.util.Tag
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class FindExpertAdapter: BaseRecyclerViewAdapter<ItemListFindExpertBinding, Expert>() {
    
    override fun inflateViewBinding(parent: ViewGroup): ItemListFindExpertBinding {
        return ItemListFindExpertBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }
    
    override val binder: (Expert, ItemListFindExpertBinding) -> Unit
        get() = { data, binding ->
            binding.apply {
                Glide.with(binding.root.context)
                    .load(data.linkImage)
                    .transform(CenterCrop(), RoundedCorners(8))
                    .into(binding.ivImage)
                
                tvName.text = data.name
                tvExperience.text = data.experience
                tvPrice.text = "IDR ${Formatting.rupiahCurrencyFormatting(data.price)}"
                
                when(data.tag) {
                    Tag.CAREER.tag -> ivTag.setImageResource(R.drawable.ic_tag_career)
                    Tag.SCHOLARSHIP.tag -> ivTag.setImageResource(R.drawable.ic_tag_scholarship)
                    Tag.COMPETITION.tag -> ivTag.setImageResource(R.drawable.ic_tag_competition)
                }
                
                btnBook.setOnClickListener {
                    val intent = Intent(itemView.context, DetailFindExpertActivity::class.java)
                    intent.putExtra(DetailFindExpertActivity.EXTRA_ID, data.id)
                    itemView.context.startActivity(intent)
                }
            }
        }
    
    override val diffUtilBuilder: (List<Expert>, List<Expert>) -> DiffUtil.Callback?
        get() = { old, new -> FindExpertDiffCallback(old, new) }
}