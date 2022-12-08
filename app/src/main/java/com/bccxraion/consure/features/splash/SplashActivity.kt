package com.bccxraion.consure.features.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.lifecycle.lifecycleScope
import com.bccxraion.consure.R
import com.bccxraion.consure.features.auth.AuthActivity
import com.bccxraion.consure.features.main.MainActivity
import kotlinx.coroutines.flow.first
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {
    
    private val viewModel by viewModel<SplashViewModel>()
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
        Handler(mainLooper).postDelayed({
            lifecycleScope.launchWhenStarted {
                viewModel.getToken().collect {
                    if (it != null) {
                        lifecycleScope.launchWhenStarted {
                            viewModel.isRememberMe().collect { isRememberMe ->
                                if (isRememberMe) {
                                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                                    finish()
                                } else {
                                    startActivity(Intent(this@SplashActivity, AuthActivity::class.java))
                                    finish()
                                }
                            }
                        }
                    } else {
                        val intent = Intent(this@SplashActivity, AuthActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            }
        }, 1000)
    }
}