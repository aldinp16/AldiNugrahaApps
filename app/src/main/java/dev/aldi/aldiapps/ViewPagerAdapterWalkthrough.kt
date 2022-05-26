package dev.aldi.aldiapps

/**
 * @author: aldinp16
 * nim: 10119908
 * kelas: IF10K
 */

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapterWalkthrough(private val context: MainActivity, private val layouts: List<Int>): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(layouts[position], container, false)
        container.addView(view)

        if (position == 2) {
            val letsgoBtn: Button = view.findViewById(R.id.lets_go_button)
            letsgoBtn.setOnClickListener{
                context.startHomeActivity()
            }
        }

        return view
    }

    override fun getCount(): Int {
        return layouts.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return  view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}

