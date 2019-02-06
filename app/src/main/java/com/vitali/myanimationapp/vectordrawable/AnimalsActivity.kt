package com.vitali.myanimationapp.vectordrawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vitali.myanimationapp.R
import kotlinx.android.synthetic.main.activity_animals.*

class AnimalsActivity : AppCompatActivity() , View.OnClickListener{

    private val STATE_SET_HIPPO = intArrayOf(R.attr.state_hippo, -R.attr.state_buffalo, -R.attr.state_elephant)
    private val STATE_SET_BUFFALO = intArrayOf(-R.attr.state_hippo, R.attr.state_buffalo, -R.attr.state_elephant)
    private val STATE_SET_ELEPHANT = intArrayOf(-R.attr.state_hippo, -R.attr.state_buffalo, R.attr.state_elephant)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)

        hippo_btn.setOnClickListener(this)
        buffalo_btn.setOnClickListener(this)
        elephant_btn.setOnClickListener(this)

    }


     private fun setHippo() {
         hippo_btn.isEnabled = false
         buffalo_btn.isEnabled = true
         elephant_btn.isEnabled = true
        icon_iv.setImageState(STATE_SET_HIPPO, true)
    }

    private fun setBuffalo() {
        hippo_btn.isEnabled = true
        buffalo_btn.isEnabled = false
        elephant_btn.isEnabled = true
        icon_iv.setImageState(STATE_SET_BUFFALO, true)
    }

    private fun setElephant() {
        hippo_btn.isEnabled = true
        buffalo_btn.isEnabled = true
        elephant_btn.isEnabled = false
        icon_iv.setImageState(STATE_SET_ELEPHANT, true)
    }


    //-----------------------------------------------------------------
    // View.OnClickListener - implementation
    //-----------------------------------------------------------------
    override fun onClick(v: View)
    {
        when(v.id)
        {
            R.id.buffalo_btn ->
            {
                setBuffalo()
            }

            R.id.elephant_btn ->
            {
                setElephant()
            }
            R.id.hippo_btn ->
            {
                setHippo()
            }
        }
    }
}
