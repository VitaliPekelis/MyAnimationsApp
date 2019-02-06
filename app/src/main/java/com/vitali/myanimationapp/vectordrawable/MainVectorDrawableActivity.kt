package com.vitali.myanimationapp.vectordrawable

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.vitali.myanimationapp.R
import kotlinx.android.synthetic.main.activity_vector_drawable.*

class MainVectorDrawableActivity : AppCompatActivity() , View.OnClickListener{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vector_drawable)

        setListeners()

    }

    private fun setListeners()
    {
        val container = vector_drawable_container
        for (index in 0 until container.childCount)
        {
            container.getChildAt(index).setOnClickListener(this)
        }
    }

    //-----------------------------------------------------------------
    // View.OnClickListener - implementation
    //-----------------------------------------------------------------
    override fun onClick(v: View)
    {
        var intent:Intent? = null

        when(v.id)
        {
            R.id.vector_drawable_animals ->
                intent = Intent(this,AnimalsActivity::class.java)

            R.id.vector_drawable_clock ->
                intent = Intent(this, ClockActivity::class.java)

            R.id.vector_drawable_checkable ->
                intent = Intent(this, CheckableActivity::class.java)

            R.id.vector_drawable_countdown ->
                intent = Intent(this, CounterActivity::class.java)

        }

        intent?.let {
            startActivity(it)
        }
    }
}
