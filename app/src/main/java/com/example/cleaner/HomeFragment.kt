package com.example.cleaner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cleaner.adapter.HomeAdapter
import com.example.cleaner.adapter.RecommendedAdapter
import com.example.cleaner.databinding.FragmentHomeBinding
import com.example.cleaner.model.Category
import com.example.cleaner.model.Recommend

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var homeAdapter: HomeAdapter
    lateinit var recommendedAdapter: RecommendedAdapter
    lateinit var arrayList: ArrayList<Category>
    lateinit var rList:ArrayList<Recommend>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayList= ArrayList()
        rList= ArrayList()
        arrayList.addAll(listOf(Category(title = "Cleaning", image = R.drawable.mop),
            Category(title = "Repearing", image = R.drawable.repair),
            Category(title = "Laundry", image = R.drawable.washing),
            Category(title = "Painting", image = R.drawable.paint),
            Category(title = "Cleaning", image = R.drawable.mop),
        ))
        rList.addAll(listOf(Recommend(R.drawable.iop,"Off 30%","Home Cleaning"),
            Recommend(R.drawable.kitchen_cleaning,"Off 20%","Kitchen Cleaning"),
            Recommend(R.drawable.iop,"Off 30%","Home Cleaning"),
            Recommend(R.drawable.kitchen_cleaning,"Off 20%","Kitchen Cleaning"),
        ))
        homeAdapter= HomeAdapter(requireContext(),arrayList)
        recommendedAdapter= RecommendedAdapter(requireContext(),rList)
        category()
        recommended()
    }

    private fun recommended() {
        binding.recommendedRv.apply {
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            adapter=recommendedAdapter
        }
    }

    private fun category() {
        binding.categoryRv.apply {
            layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter=homeAdapter
        }
    }
}