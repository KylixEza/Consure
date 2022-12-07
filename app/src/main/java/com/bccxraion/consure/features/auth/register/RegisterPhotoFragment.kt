package com.bccxraion.consure.features.auth.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bccxraion.consure.R

class RegisterPhotoFragment : Fragment() {
    
    companion object {
        fun newInstance() = RegisterPhotoFragment()
    }
    
    private lateinit var viewModel: RegisterPhotoViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register_photo, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterPhotoViewModel::class.java)
        // TODO: Use the ViewModel
    }
    
}