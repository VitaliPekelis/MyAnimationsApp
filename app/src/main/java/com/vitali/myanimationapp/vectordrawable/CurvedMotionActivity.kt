package com.vitali.myanimationapp.vectordrawable

import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vitali.myanimationapp.R
import kotlinx.android.synthetic.main.activity_curved_motion.*

class CurvedMotionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_curved_motion)
    }

    fun onClick(v: View)
    {
        val animatable = curved_motion_iv.drawable as? Animatable
        animatable?.start()
    }
}
