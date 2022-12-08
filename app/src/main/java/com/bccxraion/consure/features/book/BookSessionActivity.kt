package com.bccxraion.consure.features.book

import androidx.fragment.app.commit
import com.bccxraion.consure.R
import com.bccxraion.consure.base.BaseActivity
import com.bccxraion.consure.databinding.ActivityBookSessionBinding
import com.bccxraion.consure.features.book.package_step.PackageStepFragment
import com.bccxraion.consure.util.Constanta
import com.bccxraion.consure.util.ScreenOrientation

class BookSessionActivity : BaseActivity<ActivityBookSessionBinding>() {
    
    companion object {
        const val EXTRA_ID = "extra_id"
    }
    
    override fun inflateViewBinding(): ActivityBookSessionBinding =
        ActivityBookSessionBinding.inflate(layoutInflater)
    
    override fun determineScreenOrientation(): ScreenOrientation? = ScreenOrientation.PORTRAIT
    
    override fun ActivityBookSessionBinding.binder() {
        
        val id = intent.getStringExtra(EXTRA_ID) ?: ""
        
        Constanta.CURRENT_EXPERT_ID = id
        
        supportFragmentManager.commit {
            replace(R.id.fragment_container_book_session, PackageStepFragment())
        }
    }
}