package com.example.combinescreens.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.combinescreens.R
import com.example.combinescreens.Screen1
import com.example.combinescreens.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private val TAG = "MyActivity"
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val fragmentLayout: LinearLayout = binding.fragmentLayout
        val btnFrag: Button = binding.btnFrag
        val firstFragment: Fragment = Screen1()

        btnFrag.setOnClickListener {
//            Log.v(TAG, "index=");

            getFragmentManager()?.beginTransaction()?.apply {
                replace(R.id.fragment, firstFragment)
                fragmentLayout.visibility = View.VISIBLE
                addToBackStack(null)
                commit()
            }
        }

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        btnFrag.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment, firstFragment)
//                fragmentLayout.visibility = View.VISIBLE
//                addToBackStack(null)
//                commit()
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}