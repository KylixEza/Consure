package com.bccxraion.consure.features.book.payment_step

import android.content.Intent
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.util.Resource
import com.bccxraion.consure.databinding.FragmentPaymentStepBinding
import com.bccxraion.consure.features.book.package_step.PackageStepFragment
import com.bccxraion.consure.features.book.schedule_step.ScheduleStepFragment
import com.bccxraion.consure.features.main.MainActivity
import com.bccxraion.consure.model.transaction.TransactionBody
import com.bccxraion.consure.util.Constanta
import com.bccxraion.consure.util.ScreenOrientation
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentStepFragment : BaseFragment<FragmentPaymentStepBinding>() {
    
    private val viewModel by viewModel<PaymentStepViewModel>()
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentPaymentStepBinding =
        FragmentPaymentStepBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentPaymentStepBinding.binder() {
        
        headerBookSession.ivBookSessionProgress.setImageResource(R.drawable.img_pay_booking)
        
        btnPayNow.setOnClickListener {
            val transactionBody = TransactionBody(
                "Paket Reguler",
                "Sabtu 17/11/2022 16:30",
                70000,
                2,
                Constanta.CURRENT_EXPERT_ID.toInt()
            )
            viewModel.createTransaction(transactionBody).observe(viewLifecycleOwner) {
                when(it) {
                    is Resource.Success -> {
                        val intent = Intent(requireContext(), MainActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
                    else -> {}
                }
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        parentFragmentManager.commit {
            replace(R.id.fragment_container_book_session, ScheduleStepFragment())
        }
    }
}