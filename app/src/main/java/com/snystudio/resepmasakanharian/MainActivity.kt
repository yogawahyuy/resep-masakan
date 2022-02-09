package com.snystudio.resepmasakanharian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.snystudio.resepmasakanharian.adapter.PageAdapter
import com.snystudio.resepmasakanharian.fragment.AccountFragment
import com.snystudio.resepmasakanharian.fragment.CategoryFragment
import com.snystudio.resepmasakanharian.fragment.HomeFragment
import com.snystudio.resepmasakanharian.fragment.SaveRecipeFragment

class MainActivity : AppCompatActivity() {

    fun initComponent(){
        val viewPager:ViewPager=findViewById(R.id.main_viewpager)
        val pageAdapter : PageAdapter= PageAdapter(supportFragmentManager)
        pageAdapter.addFragments(HomeFragment())
        pageAdapter.addFragments(CategoryFragment())
        pageAdapter.addFragments(SaveRecipeFragment())
        pageAdapter.addFragments(AccountFragment())
        viewPager.adapter=pageAdapter

        val bottomNavigationView:BottomNavigationView=findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_menu->{
                    viewPager.currentItem=0
                    true
                }
                R.id.kategori_menu->{
                    viewPager.currentItem=1
                    true
                }R.id.save_recipe_menu->{
                    viewPager.currentItem=2
                true
                }R.id.account_menu->{
                    viewPager.currentItem=3
                true
                }else->false
            }
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
    }
}