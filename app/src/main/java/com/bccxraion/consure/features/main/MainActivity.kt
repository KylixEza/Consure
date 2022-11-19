package com.bccxraion.consure.features.main

import com.bccxraion.consure.base.BaseActivity
import com.bccxraion.consure.databinding.ActivityMainBinding
import com.bccxraion.consure.util.ScreenOrientation

class MainActivity : BaseActivity<ActivityMainBinding>() {
   
    override fun inflateViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    
    override fun determineScreenOrientation(): ScreenOrientation = ScreenOrientation.PORTRAIT
    
    override fun ActivityMainBinding.binder() {
    
    }
}