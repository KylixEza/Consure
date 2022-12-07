package com.bccxraion.consure.features.book.schedule_step

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bccxraion.consure.R

class ScheduleStepFragment : Fragment() {
    
    companion object {
        fun newInstance() = ScheduleStepFragment()
    }
    
    private lateinit var viewModel: ScheduleStepViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule_step, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScheduleStepViewModel::class.java)
        // TODO: Use the ViewModel
    }
    
}