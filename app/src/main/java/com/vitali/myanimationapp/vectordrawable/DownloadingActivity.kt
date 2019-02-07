package com.vitali.myanimationapp.vectordrawable

import android.graphics.drawable.Animatable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.annotation.DrawableRes
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.vitali.myanimationapp.R
import kotlinx.android.synthetic.main.activity_downloading.*

class DownloadingActivity : AppCompatActivity() {

    private var isAnimated:Boolean = false
    private var animationListener: Animatable2Compat.AnimationCallback? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloading)
    }


    override fun onStart() {
        super.onStart()
        animationListener = object: Animatable2Compat.AnimationCallback() {
            override fun onAnimationStart(drawable: Drawable?)
            {
                //Log.d("Vitali", "onAnimationStart()")
            }

            override fun onAnimationEnd(drawable: Drawable?) {
                //Log.d("Vitali", "onAnimationEnd()")
                isAnimated = false
            }
        }
    }

    override fun onStop() {
        animationListener = null
        super.onStop()
    }

    fun onClick(v:View)
    {
        if(isAnimated)
        {
            //Log.d("Vitali", "onClick() -> return")
            return
        }

        isAnimated = true

        swapAnimation(R.drawable.avd_downloading_begin, null)

        Handler().postDelayed({
            swapAnimation(R.drawable.avd_downloading_finish, animationListener)
        }, 5000)
    }

    private fun swapAnimation(@DrawableRes drawableResId: Int, listener:Animatable2Compat.AnimationCallback?)
    {
        val animatedVectorDrawable = AnimatedVectorDrawableCompat.create(this, drawableResId)

        listener?.let {callback ->
            animatedVectorDrawable?.registerAnimationCallback(callback)
        }

        downloading_iv.setImageDrawable(animatedVectorDrawable)
        (animatedVectorDrawable as? Animatable)?.start()
    }
}
