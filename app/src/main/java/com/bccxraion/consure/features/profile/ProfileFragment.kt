package com.bccxraion.consure.features.profile

import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentProfileBinding
import com.bccxraion.consure.util.ScreenOrientation

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentProfileBinding.binder() {
    
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}