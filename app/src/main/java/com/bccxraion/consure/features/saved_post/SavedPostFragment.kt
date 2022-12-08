package com.bccxraion.consure.features.saved_post

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.PostAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.source.dummy.Dummy
import com.bccxraion.consure.databinding.FragmentSavedPostBinding
import com.bccxraion.consure.util.ScreenOrientation

class SavedPostFragment : BaseFragment<FragmentSavedPostBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentSavedPostBinding =
        FragmentSavedPostBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentSavedPostBinding.binder() {
        
        includeAppBarSavedPost.tvTitle.text = "Saved Post"
        
        val postAdapter = PostAdapter()
        
        rvSavedPost.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
        postAdapter.submitList(Dummy.getDummyPost().map { it.second })
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(SavedPostFragmentDirections.actionSavedPostFragmentToNavigationProfile())
    }
}