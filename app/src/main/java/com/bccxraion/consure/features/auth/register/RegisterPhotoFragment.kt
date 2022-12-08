package com.bccxraion.consure.features.auth.register

import android.content.Intent
import android.view.ViewGroup
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentRegisterPhotoBinding
import com.bccxraion.consure.features.main.MainActivity
import com.bccxraion.consure.util.ScreenOrientation

class RegisterPhotoFragment : BaseFragment<FragmentRegisterPhotoBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentRegisterPhotoBinding {
        return FragmentRegisterPhotoBinding.inflate(layoutInflater, container, false)
    }
    
    override fun FragmentRegisterPhotoBinding.binder() {
        tvSkip.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        activity?.finish()
    }
}