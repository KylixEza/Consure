package com.bccxraion.consure.features.profile

import android.content.Intent
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.R
import com.bccxraion.consure.adapter.UpcomingSessionAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentProfileBinding
import com.bccxraion.consure.features.auth.AuthActivity
import com.bccxraion.consure.util.ScreenOrientation
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {
    
    private val viewModel by viewModel<ProfileViewModel>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentProfileBinding =
        FragmentProfileBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentProfileBinding.binder() {
        includeAppBarProfile.tvTitle.text = "My Profile"
        
        val upcomingSessionAdapter = UpcomingSessionAdapter()
        
        rvUpcomingSession.apply {
            adapter = upcomingSessionAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
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
        
        viewModel.fetchScheduledSchedule().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> it.data?.let { it1 -> upcomingSessionAdapter.submitList(it1) }
                is Resource.Empty -> upcomingSessionAdapter.submitList(emptyList())
                else -> {}
            }
        }
        
        ivForwardProfileBookingHistory.setOnClickListener {
            view?.findNavController()?.navigate(ProfileFragmentDirections.actionNavigationProfileToBookingHistoryFragment())
        }
        
        ivForwardProfileSaved.setOnClickListener {
            view?.findNavController()?.navigate(ProfileFragmentDirections.actionNavigationProfileToSavedPostFragment())
        }
        
        ivForwardProfileNotification.setOnClickListener {
            view?.findNavController()?.navigate(ProfileFragmentDirections.actionNavigationProfileToNotificationFragment())
        }
        
        tvProfileLogOut.setOnClickListener {
            viewModel.removeToken()
            val intent = Intent(requireContext(), AuthActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(ProfileFragmentDirections.actionNavigationProfileToNavigationHome())
    }
}