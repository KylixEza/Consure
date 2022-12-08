package com.bccxraion.consure.features.auth.register

import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentRegisterBinding
import com.bccxraion.consure.features.auth.login.LoginFragment
import com.bccxraion.consure.model.user.UserBody
import com.bccxraion.consure.util.ScreenOrientation
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment<FragmentRegisterBinding>() {
    
    private val viewModel by viewModel<RegisterViewModel>()
    
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
        
        btnSignUp.setOnClickListener {
            val body = UserBody(
                tietUsername.text.toString(),
                tietPassword.text.toString(),
                tietEmail.text.toString()
            )
            viewModel.signUp(body).observe(viewLifecycleOwner) {
                when(it) {
                    is Resource.Success -> parentFragmentManager.commit {
                        replace(
                            R.id.fragment_container_auth,
                            RegisterPhotoFragment(),
                        )
                    }
                    else -> {}
                }
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