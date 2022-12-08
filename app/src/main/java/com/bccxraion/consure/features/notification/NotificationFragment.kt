package com.bccxraion.consure.features.notification

import android.view.ViewGroup
import androidx.navigation.findNavController
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentNotificationBinding
import com.bccxraion.consure.util.ScreenOrientation

class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {
    override fun inflateViewBinding(container: ViewGroup?): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(layoutInflater, container, false)
    }
    
    override fun FragmentNotificationBinding.binder() {
        includeAppBarSavedPost.tvTitle.text = "Notifications"
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(NotificationFragmentDirections.actionNotificationFragmentToNavigationProfile())
    }
}