package com.vitali.myanimationapp.vectordrawable

import android.graphics.drawable.Animatable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.vitali.myanimationapp.R
import kotlinx.android.synthetic.main.activity_clock_actitivty.*

class ClockActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock_actitivty)

        alarm_iv.setOnClickListener(this)
        clock_iv.setOnClickListener(this)
        timer_iv.setOnClickListener(this)
        stopwatch_iv.setOnClickListener(this)

    }

    //-----------------------------------------------------------------
    // View.OnClickListener - implementation
    //-----------------------------------------------------------------
    override fun onClick(v: View)
    {
        val view = v as? ImageView
        (view?.drawable as Animatable).start()
    }
}
