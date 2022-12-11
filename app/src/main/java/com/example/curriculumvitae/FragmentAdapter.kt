package com.example.curriculumvitae

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

@Suppress("DEPRECATION")
class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, bundle: Bundle?) : FragmentStateAdapter(fragmentManager, lifecycle) {

    val bundle = bundle
    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> {
                val frag = AboutMeFragment()
                frag.arguments = bundle
                return frag
            }
            2 -> {
                val frag = WorkFragment()
                frag.arguments = bundle
                return frag
            }
            3 -> {
                val frag = ProjectsFragment()
                frag.arguments = bundle
                return frag
            }
            4 -> {
                val frag = ContactFragment()
                frag.arguments = bundle
                return frag
            }

            else ->  {
                val frag = HomeFragment()
                frag.arguments = bundle
                return frag
            }
        }
    }
}