package com.bccxraion.consure.features.book.payment_step

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bccxraion.consure.R

class PaymentStepFragment : Fragment() {
    
    companion object {
        fun newInstance() = PaymentStepFragment()
    }
    
    private lateinit var viewModel: PaymentStepViewModel
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_payment_step, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PaymentStepViewModel::class.java)
        // TODO: Use the ViewModel
    }
    
}