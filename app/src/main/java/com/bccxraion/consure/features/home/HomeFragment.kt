package com.bccxraion.consure.features.home

import android.content.Intent
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.PostAdapter
import com.bccxraion.consure.adapter.TopExpertAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.source.dummy.Dummy
import com.bccxraion.consure.databinding.FragmentHomeBinding
import com.bccxraion.consure.features.tag.TagActivity
import com.bccxraion.consure.util.ScreenOrientation
import com.bccxraion.consure.util.Tag

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentHomeBinding =
        FragmentHomeBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentHomeBinding.binder() {
        val topExpertsAdapter = TopExpertAdapter()
        val postAdapter = PostAdapter()
        
        rvTopExpertsForYou.apply {
            adapter = topExpertsAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        
        rvPost.apply {
            adapter = postAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
        postAdapter.submitList(Dummy.getDummyPost().map { it.second })
        topExpertsAdapter.submitList(Dummy.getFakeTopExperts().map { it.second }.take(2))
        
        includeExpertCategoryHome.apply {
            val intent = Intent(requireContext(), TagActivity::class.java)
            ivCareer.setOnClickListener {
                view?.findNavController()?.navigate(HomeFragmentDirections.actionNavigationHomeToTagFragment(Tag.CAREER.tag))
            }
            ivScholarship.setOnClickListener {
                view?.findNavController()?.navigate(HomeFragmentDirections.actionNavigationHomeToTagFragment(Tag.SCHOLARSHIP.tag))
            }
            ivCompetition.setOnClickListener {
                view?.findNavController()?.navigate(HomeFragmentDirections.actionNavigationHomeToTagFragment(Tag.COMPETITION.tag))
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        requireActivity().finish()
    }
}