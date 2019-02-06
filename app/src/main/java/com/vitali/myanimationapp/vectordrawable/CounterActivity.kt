package com.vitali.myanimationapp.vectordrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vitali.myanimationapp.R
import kotlinx.android.synthetic.main.activity_counter.*

class CounterActivity : AppCompatActivity(), View.OnClickListener {


    private var currentDigitStateIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        plus_btn.setOnClickListener(this)
        minus_btn.setOnClickListener(this)

    }

    private fun decrementCount()
    {
        // Decrement the countdown view by one.
        if(currentDigitStateIndex == 0)
        {
            currentDigitStateIndex = DIGIT_STATES.size - 1
        }
        else
        {
            currentDigitStateIndex--
        }
    }

    private fun incrementCount()
    {
        // Increment the count view by one.
        if(currentDigitStateIndex == DIGIT_STATES.size - 1)
        {
            currentDigitStateIndex = 0
        }
        else
        {
            currentDigitStateIndex++
        }
    }

    private fun getStateArray(): IntArray
    {
        val stateArray = IntArray(DIGIT_STATES.size)
        for (i in stateArray.indices)
        {
            if (i == currentDigitStateIndex)
            {
                stateArray[i] = DIGIT_STATES[i]
            }
            else
            {
                stateArray[i] = -DIGIT_STATES[i]
            }
        }

        return stateArray
    }

    //-----------------------------------------------------------------
    // View.OnClickListener - implementation
    //-----------------------------------------------------------------
    override fun onClick(v: View)
    {
        val countdownView = digitIcon_iv

        when(v.id)
        {
            R.id.plus_btn ->
                incrementCount()

            R.id.minus_btn ->
                decrementCount()
        }

        countdownView.setImageState(getStateArray(), true)
    }

    //-----------------------------------------------------------------
    // abstract
    //-----------------------------------------------------------------
    companion object
    {
        private val DIGIT_STATES = intArrayOf(
            R.attr.state_zero,
            R.attr.state_one,
            R.attr.state_two,
            R.attr.state_three,
            R.attr.state_four,
            R.attr.state_five,
            R.attr.state_six,
            R.attr.state_seven,
            R.attr.state_eight,
            R.attr.state_nine)
    }
}
