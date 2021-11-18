package com.example.combinescreens.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.combinescreens.Screen1
import com.example.combinescreens.Screen2
import com.example.combinescreens.Screen3
import com.example.combinescreens.databinding.FragmentNotificationsBinding

const val NUM_PAGES = 3

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private lateinit var viewPager: ViewPager2

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textNotifications
        val viewPager: ViewPager2 = binding.viewPager
        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }


    private inner class ScreenSlidePagerAdapter(fa: NotificationsFragment) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = NUM_PAGES

//        override fun createFragment(position: Int): Fragment = Screen2()
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> Screen1()
                1 -> Screen2()
                2 -> Screen3()
                else -> throw RuntimeException("$this Wrong fragment!")
                }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}