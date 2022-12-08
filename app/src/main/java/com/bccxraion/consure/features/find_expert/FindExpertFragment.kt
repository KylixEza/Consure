package com.bccxraion.consure.features.find_expert

import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.FindExpertAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentFindExpertBinding
import com.bccxraion.consure.util.ScreenOrientation
import com.bccxraion.consure.util.Tag
import org.koin.androidx.viewmodel.ext.android.viewModel

class FindExpertFragment : BaseFragment<FragmentFindExpertBinding>() {
    
    private val viewModel by viewModel<FindExpertViewModel>()
    private lateinit var adapter : FindExpertAdapter
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentFindExpertBinding =
        FragmentFindExpertBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentFindExpertBinding.binder() {
        adapter = FindExpertAdapter()
        
        rvFindExpert.apply {
            this.adapter = this@FindExpertFragment.adapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
        fetchAllExperts()
        
        chipAll.setOnClickListener {
            if (!isAllChipNotChecked()) {
                fetchAllExperts()
            } else {
                chipAll.isChecked = true
            }
        }
        
        chipCareer.setOnClickListener {
            if (!isAllChipNotChecked()) {
                fetchExpertsByTag(Tag.CAREER.tag)
            } else {
                chipCareer.isChecked = true
            }
        }
        
        chipCompetition.setOnClickListener {
            if (!isAllChipNotChecked()) {
                fetchExpertsByTag(Tag.COMPETITION.tag)
            } else {
                chipCompetition.isChecked = true
            }
        }
        
        chipScholarship.setOnClickListener {
            if (!isAllChipNotChecked()) {
                fetchExpertsByTag(Tag.SCHOLARSHIP.tag)
            } else {
                chipScholarship.isChecked = true
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    private fun fetchAllExperts() {
        viewModel.fetchAllExperts().observe(viewLifecycleOwner) { resource ->
            when(resource) {
                is Resource.Success -> {
                    resource.data?.let { adapter.submitList(it) }
                }
                is Resource.Error -> Toast.makeText(requireContext(), resource.message, Toast.LENGTH_SHORT).show()
                else -> {}
            }
        }
    }
    
    private fun fetchExpertsByTag(tag: String) {
        viewModel.fetchExpertsByTag(tag).observe(viewLifecycleOwner) { resource ->
            when(resource) {
                is Resource.Success -> {
                    resource.data?.let { adapter.submitList(it) }
                }
                is Resource.Error -> Toast.makeText(requireContext(), resource.message, Toast.LENGTH_SHORT).show()
                else -> {}
            }
        }
    }
    
    private fun isAllChipNotChecked() : Boolean {
        return binding?.chipAll?.isChecked == false && binding?.chipCareer?.isChecked == false && binding?.chipCompetition?.isChecked == false && binding?.chipScholarship?.isChecked == false
    }
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(FindExpertFragmentDirections.actionNavigationFindExpertToNavigationHome())
    }
    
}