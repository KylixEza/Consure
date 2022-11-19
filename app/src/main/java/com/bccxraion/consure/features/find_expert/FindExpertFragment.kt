package com.bccxraion.consure.features.find_expert

import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentFindExpertBinding
import com.bccxraion.consure.util.ScreenOrientation

class FindExpertFragment : BaseFragment<FragmentFindExpertBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentFindExpertBinding =
        FragmentFindExpertBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentFindExpertBinding.binder() {
    
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}