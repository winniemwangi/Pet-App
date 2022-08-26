package com.winnie.thepetnanny

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter (val context : Context): PagerAdapter() {

    var layoutInflater : LayoutInflater? = null

    //arrays of images, head and description

    val imgArray = arrayOf(
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5
    )

    val headArray = arrayOf(
        "Medical Care",
        "Cat Declawing",
        "Deworming",
        "Cat Spay"
    )

    val descriptionArray = arrayOf(
        "There is nothing more exciting for many families than bringing home a healthy pet – especially if it is a kitten.",
        "To ensure that cat owners find approved surfaces that their cat can use to sharpen their claws or keep them well-maintained.",
        "To ensure that your cat has the prevention products necessary to eliminate fleas and ticks before they become a problem",
        "As a surgical procedure, this process ensures that a cat is unable to reproduce"
    )

    override fun getCount(): Int {
        return headArray.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider,container, false)

        val img = view.findViewById<ImageView>(R.id.imgMedCare)
        val head = view.findViewById<TextView>(R.id.tvTitle1)
        val text = view.findViewById<TextView>(R.id.tvText1)

        img.setImageResource(imgArray[position])
        head.text = headArray[position]
        text.text = descriptionArray[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}