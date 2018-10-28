package com.kotlin.placeholder

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.AnkoLogger

class SplashFragment : Fragment(), AnkoLogger {

    lateinit var interaction: SplashFragmentInteraction

    interface SplashFragmentInteraction {
        fun startApp()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context != null) {
            initInteraction(context)
        }
    }

    private fun initInteraction(context: Context) {
        interaction = context as SplashFragmentInteraction
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.splash_fragment, container, false)

        GlobalScope.launch(Dispatchers.Main) {
            delay(500)
            interaction.startApp()
        }

        return view
    }

//    class StartHandlerThread :HandlerThread()

    companion object {

        const val TAG = "SplashFragment"

        fun newInstance() = SplashFragment()
    }
}