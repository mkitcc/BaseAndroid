package org.itsman.fastlibrary.ui.activity

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.compose.setContent
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.itsman.fastlibrary.R
import org.itsman.fastlibrary.base.BaseActivity
import org.itsman.fastlibrary.databinding.ActivityNewMainBinding
import org.itsman.fastlibrary.databinding.ItemTabBinding
import org.itsman.fastlibrary.ui.compose.theme.BaseAndroidTheme
import org.itsman.fastlibrary.ui.fragment.AboutFragment
import org.itsman.fastlibrary.ui.fragment.HomeFragment

class NewMainActivity : BaseActivity() {

    private lateinit var binding: ActivityNewMainBinding
    var fragmentList = mutableListOf<Fragment>()
    var fragmentAdapter: FragmentStateAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        initData()
    }

    fun initView() {
        //init viewpage2
        fragmentAdapter = object : FragmentStateAdapter(this) {
            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getItemCount() = fragmentList.size
        }
        binding.viewpage2.adapter = fragmentAdapter
        binding.viewpage2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int,
            ) {
//                binding.tab.setScrollPosition(position, 0f, true)
            }
        })

        //init tab
        for (i in 0..2) {
//            binding.tab.addTab(binding.tab.newTab().apply {
//                setText("$i$i$i")
//                customView
//            })
        }
        binding.tab.apply {
//            tabRippleColor = ColorStateList.valueOf(Color.RED)
//            setSelectedTabIndicatorColor(getColor(R.color.purple_500))
            addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val customView = tab?.customView
                    customView?.let {
                        val binding = ItemTabBinding.bind(customView)
                        binding.tvLabel.text="current"

                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                    val customView = tab?.customView
                    customView?.let {
                        val binding = ItemTabBinding.bind(customView)
                        binding.tvLabel.text="Home"
                    }
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }

            })
        }
        TabLayoutMediator(binding.tab,binding.viewpage2){position,i->
            position.customView= layoutInflater.inflate(R.layout.item_tab,null)
        }.attach()
    }

    fun initData() {
        fragmentList.add(HomeFragment())
        fragmentList.add(AboutFragment())
        fragmentAdapter?.notifyDataSetChanged()
    }
}