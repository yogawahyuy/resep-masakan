package com.snystudio.resepmasakanharian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.snystudio.resepmasakanharian.adapter.PageAdapter
import com.snystudio.resepmasakanharian.databinding.ActivityMainBinding
import com.snystudio.resepmasakanharian.fragment.AccountFragment
import com.snystudio.resepmasakanharian.fragment.CategoryFragment
import com.snystudio.resepmasakanharian.fragment.HomeFragment
import com.snystudio.resepmasakanharian.fragment.SaveRecipeFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)
        binding.bottomNavigation.setupWithNavController(navController)
    }


}