package com.bccxraion.consure.features.detail_find_expert

import android.widget.Toast
import com.bccxraion.consure.base.BaseActivity
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.ActivityDetailFindExpertBinding
import com.bccxraion.consure.util.ScreenOrientation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFindExpertActivity : BaseActivity<ActivityDetailFindExpertBinding>() {
    
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    
    private val viewModel by viewModel<DetailFindExpertViewModel>()
    
    override fun inflateViewBinding(): ActivityDetailFindExpertBinding {
        return ActivityDetailFindExpertBinding.inflate(layoutInflater)
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun ActivityDetailFindExpertBinding.binder() {
        val id = intent.getStringExtra(EXTRA_ID) ?: ""
        
        viewModel.fetchExpertById(id).observe(this@DetailFindExpertActivity) {
            when(it) {
                is Resource.Empty -> { }
                is Resource.Error -> Toast.makeText(this@DetailFindExpertActivity, it.message, Toast.LENGTH_SHORT).show()
                is Resource.Loading -> { }
                is Resource.Success -> {
                    Glide.with(this@DetailFindExpertActivity)
                        .load(it.data?.linkImage)
                        .transform(CenterCrop(), RoundedCorners(8))
                        .into(ivProfile)
                    
                    tvExpertName.text = it.data?.name
                    includeTag.tvTagExpertise.text = it.data?.tag
                    tvDetailExperience.text = it.data?.experience
                }
            }
        }
    }
    
}