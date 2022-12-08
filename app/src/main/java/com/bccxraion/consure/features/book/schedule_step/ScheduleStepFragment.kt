package com.bccxraion.consure.features.book.schedule_step

import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentScheduleStepBinding
import com.bccxraion.consure.features.book.package_step.PackageStepFragment
import com.bccxraion.consure.features.book.payment_step.PaymentStepFragment
import com.bccxraion.consure.util.Constanta
import com.bccxraion.consure.util.ScreenOrientation
import com.bumptech.glide.Glide
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScheduleStepFragment : BaseFragment<FragmentScheduleStepBinding>() {
    
    private val viewModel by viewModel<ScheduleStepViewModel>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentScheduleStepBinding =
        FragmentScheduleStepBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentScheduleStepBinding.binder() {
        headerBookSession.ivBookSessionProgress.setImageResource(R.drawable.img_schedule_booking)
        
        btnNext.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_book_session, PaymentStepFragment())
            }
        }
        
        viewModel.fetchExpertById(Constanta.CURRENT_EXPERT_ID).observe(viewLifecycleOwner) {
            when(it) {
                is Resource.Success -> {
                    Glide.with(requireContext())
                        .load(it.data?.linkImage)
                        .into(ivAvatar)
                    tvName.text = it.data?.name
                    includeTag.tvTagExpertise.text = it.data?.tag
                }
                else -> {}
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        parentFragmentManager.commit {
            replace(R.id.fragment_container_book_session, PackageStepFragment())
        }
    }
}