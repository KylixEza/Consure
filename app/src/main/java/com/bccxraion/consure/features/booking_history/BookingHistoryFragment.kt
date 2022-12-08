package com.bccxraion.consure.features.booking_history

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.HistoryAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentBookingHistoryBinding
import com.bccxraion.consure.util.ScreenOrientation
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingHistoryFragment : BaseFragment<FragmentBookingHistoryBinding>() {
    
    private val viewModel by viewModel<BookingHistoryViewModel>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentBookingHistoryBinding =
        FragmentBookingHistoryBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentBookingHistoryBinding.binder() {
        includeAppBarBookingHistory.tvTitle.text = "Booking History"
        
        val historyAdapter = HistoryAdapter()
        
        rvBookingHistory.apply {
            adapter = historyAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
        viewModel.fetchFinishedSchedule().observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Success -> it.data?.let { it1 -> historyAdapter.submitList(it1) }
                else -> {}
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(BookingHistoryFragmentDirections.actionBookingHistoryFragmentToNavigationProfile())
    }
}