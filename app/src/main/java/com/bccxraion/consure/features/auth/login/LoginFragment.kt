package com.bccxraion.consure.features.auth.login

import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentLoginBinding
import com.bccxraion.consure.util.ScreenOrientation

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentLoginBinding.binder() {
    
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}