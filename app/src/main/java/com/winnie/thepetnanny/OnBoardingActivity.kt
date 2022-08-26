package com.winnie.thepetnanny

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator


class OnBoardingActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: ViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val relativelayout = findViewById<RelativeLayout>(R.id.layout1)
        val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
        val animationDrawable = relativelayout.background as AnimationDrawable
        val btn = findViewById<Button>(R.id.btnStart)

        btn.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        addAnimation(animationDrawable)

        viewPager = findViewById(R.id.viewPager)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        dotsIndicator.setViewPager(viewPager)

        viewPager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                if(position==3){
                    btn.visibility = View.VISIBLE
                }
            }

            override fun onPageSelected(position: Int) {

                if (position == 0){
                    relativelayout.setBackgroundResource(R.drawable.gradient_animation)
                    val animationDrawable = relativelayout.background as AnimationDrawable
                    addAnimation(animationDrawable)

                }
            }

            override fun onPageScrollStateChanged(state: Int) {

            }

        })
    }

    fun addAnimation(animationDrawable: AnimationDrawable){
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
    }
}