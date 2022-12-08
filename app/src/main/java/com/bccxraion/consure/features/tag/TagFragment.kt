package com.bccxraion.consure.features.tag

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.PostAdapter
import com.bccxraion.consure.adapter.TopExpertAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.source.dummy.Dummy
import com.bccxraion.consure.databinding.FragmentTagBinding
import com.bccxraion.consure.util.ScreenOrientation

class TagFragment : BaseFragment<FragmentTagBinding>() {
    
    companion object {
        const val EXTRA_TAG = "EXTRA_TAG"
    }
    
    private val args by navArgs<TagFragmentArgs>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentTagBinding {
        return FragmentTagBinding.inflate(layoutInflater, container, false)
    }
    
    override fun FragmentTagBinding.binder() {
        val tag = args.tag
        includeAppBarTag.tvTitle.text = "${tag}s"
        tvExperts.text = "$tag Experts"
        tvPosts.text = "$tag Posts"
    
        val topExpertAdapter = TopExpertAdapter()
        val postAdapter = PostAdapter()
    
        rvExperts.apply {
            adapter = topExpertAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    
        rvPosts.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    
        postAdapter.submitList(Dummy.getDummyPost().filter { it.first == tag }.map { it.second })
        topExpertAdapter.submitList(Dummy.getFakeTopExperts().filter { it.first == tag }.map { it.second })
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(TagFragmentDirections.actionTagFragmentToNavigationHome())
    }
}