package com.bccxraion.consure.features.auth.register

import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentRegisterBinding
import com.bccxraion.consure.features.auth.login.LoginFragment
import com.bccxraion.consure.util.ScreenOrientation

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentRegisterBinding =
        FragmentRegisterBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentRegisterBinding.binder() {
        tvAlreadyHaveAnAccount.setOnClickListener {
            parentFragmentManager.commit {
                replace(
                    R.id.fragment_container_auth,
                    LoginFragment(),
                )
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        parentFragmentManager.commit {
            replace(
                R.id.fragment_container_auth,
                LoginFragment(),
            )
        }
    }
    
}