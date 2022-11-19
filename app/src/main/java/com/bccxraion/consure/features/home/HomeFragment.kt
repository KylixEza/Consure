package com.bccxraion.consure.features.home

import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentHomeBinding
import com.bccxraion.consure.util.ScreenOrientation

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentHomeBinding.binder() {
    
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}