package com.bccxraion.consure.features.auth.login

import android.content.Intent
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentLoginBinding
import com.bccxraion.consure.features.auth.register.RegisterFragment
import com.bccxraion.consure.features.main.MainActivity
import com.bccxraion.consure.model.user.UserBody
import com.bccxraion.consure.util.ScreenOrientation
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    
    private val viewModel by viewModel<LoginViewModel>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentLoginBinding =
        FragmentLoginBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentLoginBinding.binder() {
        
        btnSignIn.setOnClickListener {
            val email = tietEmail.text.toString()
            val password = tietPassword.text.toString()
            val userBody = UserBody(
                email = email,
                password = password
            )
            viewModel.signIn(userBody).observe(viewLifecycleOwner) {
                when (it) {
                    is Resource.Success -> {
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                    is Resource.Error -> {
                        Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                    }
                    else -> {}
                }
            }
        }
        
        tvDoNotHaveAccount.setOnClickListener {
            parentFragmentManager.commit {
                replace(
                    R.id.fragment_container_auth,
                    RegisterFragment(),
                )
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        activity?.finish()
    }
}