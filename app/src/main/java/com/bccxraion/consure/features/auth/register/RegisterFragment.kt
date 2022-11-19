package com.bccxraion.consure.features.auth.register

import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentRegisterBinding
import com.bccxraion.consure.util.ScreenOrientation

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentRegisterBinding =
        FragmentRegisterBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentRegisterBinding.binder() {
    
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}