package com.bccxraion.consure.features.book.package_step

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bccxraion.consure.R

class PackageStepFragment : Fragment() {
    
    companion object {
        fun newInstance() = PackageStepFragment()
    }
    
    private lateinit var viewModel: PackageStepViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_package_step, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PackageStepViewModel::class.java)
        // TODO: Use the ViewModel
    }
    
}