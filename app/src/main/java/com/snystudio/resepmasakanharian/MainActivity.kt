package com.snystudio.resepmasakanharian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.snystudio.resepmasakanharian.adapter.PageAdapter
import com.snystudio.resepmasakanharian.fragment.AccountFragment
import com.snystudio.resepmasakanharian.fragment.CategoryFragment
import com.snystudio.resepmasakanharian.fragment.HomeFragment
import com.snystudio.resepmasakanharian.fragment.SaveRecipeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private val mOnNavigationListener=BottomNavigationView.OnNavigationItemSelectedListener{
        when(it.itemId) {
            R.id.home_menu -> {
              val fragment=HomeFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.kategori_menu -> {
                val fragment=CategoryFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.save_recipe_menu -> {
                val fragment=SaveRecipeFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.account_menu -> {
                val fragment=AccountFragment()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }
    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
            .replace(R.id.contents, fragment, fragment.javaClass.getSimpleName())
            .commit()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationListener)
        val fragment=HomeFragment()
        addFragment(fragment)
    }


}