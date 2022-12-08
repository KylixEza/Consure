package com.bccxraion.consure.features.book.package_step

import android.view.ViewGroup
import androidx.fragment.app.commit
import com.bccxraion.consure.R
import com.bccxraion.consure.adapter.PackageStepAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.databinding.FragmentPackageStepBinding
import com.bccxraion.consure.features.book.schedule_step.ScheduleStepFragment
import com.bccxraion.consure.util.ScreenOrientation

class PackageStepFragment : BaseFragment<FragmentPackageStepBinding>() {
    
    private lateinit var adapter: PackageStepAdapter
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentPackageStepBinding =
        FragmentPackageStepBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentPackageStepBinding.binder() {
        //adapter = PackageStepAdapter()
        
        headerBookSession.ivBookSessionProgress.setImageResource(R.drawable.img_package_booking)
        /*
        rvPackages.apply {
            adapter = this@PackageStepFragment.adapter
            layoutManager  = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
        adapter.submitList(Dummy.getFakePackages())*/
        
        /*adapter.listener = object: PackageStepListener {
            override fun onPackageStepClicked() {
                parentFragmentManager.commit {
                    replace(R.id.fragment_container_book_session, ScheduleStepFragment())
                }
            }
        }*/
        
        ivPackage1.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container_book_session, ScheduleStepFragment())
            }
        }
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        activity?.finish()
    }
}