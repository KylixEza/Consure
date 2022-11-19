package com.bccxraion.consure.features.main

import androidx.navigation.findNavController
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseActivity
import com.bccxraion.consure.databinding.ActivityMainBinding
import com.bccxraion.consure.util.ScreenOrientation
import github.com.st235.lib_expandablebottombar.navigation.ExpandableBottomBarNavigationUI

class MainActivity : BaseActivity<ActivityMainBinding>() {
   
    override fun inflateViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun ActivityMainBinding.binder() {
        val navController = findNavController(R.id.nav_host_main)
        ExpandableBottomBarNavigationUI.setupWithNavController(
            binding.expandableBottomNav,
            navController
        )
    }
}