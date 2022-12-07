package com.bccxraion.consure.features.tag

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.TopExpertAdapter
import com.bccxraion.consure.base.BaseActivity
import com.bccxraion.consure.data.source.dummy.Dummy
import com.bccxraion.consure.databinding.ActivityTagBinding
import com.bccxraion.consure.util.ScreenOrientation

class TagActivity : BaseActivity<ActivityTagBinding>() {
    
    companion object {
        const val EXTRA_TAG = "EXTRA_TAG"
    }
    
    override fun inflateViewBinding(): ActivityTagBinding {
        return ActivityTagBinding.inflate(layoutInflater)
    }
    
    override fun determineScreenOrientation(): ScreenOrientation? {
        return ScreenOrientation.PORTRAIT
    }
    
    override fun ActivityTagBinding.binder() {
        val tag = intent.getStringExtra(EXTRA_TAG)
        includeAppBarTag.tvTitle.text = "${tag}s"
        tvExperts.text = "$tag Experts"
        tvPosts.text = "$tag Posts"
        
        val topExpertAdapter = TopExpertAdapter()
        
        rvExperts.apply {
            adapter = topExpertAdapter
            layoutManager = LinearLayoutManager(this@TagActivity, LinearLayoutManager.HORIZONTAL, false)
        }
        
        topExpertAdapter.submitList(Dummy.getFakeTopExperts().filter { it.first == tag }.map { it.second })
        
    }
}