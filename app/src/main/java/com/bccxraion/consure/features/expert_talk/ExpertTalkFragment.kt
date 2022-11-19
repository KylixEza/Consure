package com.bccxraion.consure.features.expert_talk

import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentExpertTalkBinding
import com.bccxraion.consure.util.ScreenOrientation

class ExpertTalkFragment : BaseFragment<FragmentExpertTalkBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentExpertTalkBinding =
        FragmentExpertTalkBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentExpertTalkBinding.binder() {
    
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}