/*
package com.example.cocinamos

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

*/
/**
 * Base class. Sets up the list of fragments and implements UI to
 *//*

abstract class BaseCardActivity : FragmentActivity() {

    protected lateinit var viewPager: ViewPager2

    protected open val layoutId: Int = R.layout.activity_no_tablayout

    private val mAnimator = ViewPager2.PageTransformer { page, position ->
        val absPos = abs(position)
        page.apply {
            translationY = absPos * 500f
            translationX = absPos * 350f
            val scale = if (absPos > 1) 0F else 1 - absPos
            scaleX = scale
            scaleY = scale
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        viewPager = findViewById(R.id.view_pager)

        viewPager.setPageTransformer(mAnimator)

    }
}
*/
