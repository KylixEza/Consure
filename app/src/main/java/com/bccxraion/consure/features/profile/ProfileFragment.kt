package com.bccxraion.consure.features.profile

import android.view.ViewGroup
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentProfileBinding
import com.bccxraion.consure.util.ScreenOrientation
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    
    private val viewModel by viewModel<ProfileViewModel>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentProfileBinding.binder() {
        includeAppBarProfile.tvTitle.text = "My Profile"
        
        viewModel.getProfile().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    tvName.text = it.data?.username
                    Glide.with(requireContext())
                        .load(it.data?.linkImage)
                        .centerCrop()
                        .placeholder(R.drawable.ilu_default_profile_picture)
                        .into(ivAvatar)
                }
               else -> {}
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
}