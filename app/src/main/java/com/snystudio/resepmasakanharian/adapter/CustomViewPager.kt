package com.snystudio.resepmasakanharian.adapter

import android.content.Context
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

class CustomViewPager(context: Context) : ViewPager(context) {

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return super.onTouchEvent(ev)
    }

}