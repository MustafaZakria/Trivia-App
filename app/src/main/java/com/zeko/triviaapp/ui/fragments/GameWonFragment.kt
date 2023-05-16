package com.zeko.triviaapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.zeko.triviaapp.R
import com.zeko.triviaapp.databinding.FragmentGameOverBinding
import com.zeko.triviaapp.databinding.FragmentGameWonBinding

class GameWonFragment : Fragment() {
    private lateinit var binding: FragmentGameWonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_won, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextMatchButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_gameOverFragment3_to_titleFragment3)
        )
    }

}