package com.bccxraion.consure.features.expert_talk

import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bccxraion.consure.adapter.ChatAdapter
import com.bccxraion.consure.base.BaseFragment
import com.bccxraion.consure.data.source.dummy.Dummy
import com.bccxraion.consure.databinding.FragmentExpertTalkBinding
import com.bccxraion.consure.util.ScreenOrientation

class ExpertTalkFragment : BaseFragment<FragmentExpertTalkBinding>() {
    
    override fun inflateViewBinding(container: ViewGroup?): FragmentExpertTalkBinding =
        FragmentExpertTalkBinding.inflate(layoutInflater, container, false)
    
    override fun FragmentExpertTalkBinding.binder() {
        val chatAdapter = ChatAdapter()
        
        rvChat.apply {
            adapter = chatAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
        
        chatAdapter.submitList(Dummy.getDummyChat())
    }
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun onBackPressedBehaviour() {
        view?.findNavController()?.navigate(ExpertTalkFragmentDirections.actionNavigationExpertTalkToNavigationHome())
    }
}