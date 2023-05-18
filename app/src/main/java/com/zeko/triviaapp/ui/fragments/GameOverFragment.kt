package com.zeko.triviaapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.zeko.triviaapp.R
import com.zeko.triviaapp.databinding.FragmentGameOverBinding

class GameOverFragment : Fragment() {
    private lateinit var binding: FragmentGameOverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_over, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = GameOverFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "Score is ${args.score}", Toast.LENGTH_SHORT).show()

        binding.tryAgainButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(GameOverFragmentDirections.actionGameOverFragmentToTitleFragment())
        )
    }
}