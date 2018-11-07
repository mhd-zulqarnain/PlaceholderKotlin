package com.kotlin.placeholder

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.placeholder.mainsreen.users.UsersFragment

class MainActivity : AppCompatActivity(), SplashFragment.SplashFragmentInteraction {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startSplashFragment()

    }

    private fun startSplashFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(android.R.id.content, SplashFragment.newInstance())
                .commit()
    }

    override fun startApp() {
        UsersFragment.startFragment(supportFragmentManager)
    }
}
