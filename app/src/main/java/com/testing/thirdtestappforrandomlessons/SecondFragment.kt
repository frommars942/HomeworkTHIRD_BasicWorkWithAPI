package com.testing.thirdtestappforrandomlessons

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        secondButtonClick() // --> DOESNT WORK | ПОГУГЛИТЬ ПОЧЕМУ
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SecondFragment()
    }

    // simple function with onclick for new button -- DOESNT WORK FUCK
    private fun secondButtonClick() {
        Log.i("View_test", "FUN CALLED!")


        activity?.findViewById<Button>(R.id.exit_button)?.setOnClickListener {
            Log.i("SecondButton_test", "BUTTON PRESSED, HERE WE GO!")
            activity?.supportFragmentManager?.beginTransaction()?.hide(this)?.commit()
        }
    }
}