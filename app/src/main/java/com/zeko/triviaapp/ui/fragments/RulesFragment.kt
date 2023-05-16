package com.zeko.triviaapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zeko.triviaapp.R
import com.zeko.triviaapp.databinding.FragmentRulesBinding

class RulesFragment : Fragment() {
    private lateinit var binding: FragmentRulesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_rules, container, false)
        return binding.root
    }
}