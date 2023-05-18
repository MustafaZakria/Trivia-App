package com.zeko.triviaapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.zeko.triviaapp.databinding.FragmentGameBinding
import com.zeko.triviaapp.ui.viewmodels.MainViewModel


class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, com.zeko.triviaapp.R.layout.fragment_game, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        var answer: String? = null

        val radioGroup: RadioGroup = binding.questionRadioGroup
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById<RadioButton>(checkedId)
            answer = checkedRadioButton?.text?.toString()
        }

        binding.nextButton.setOnClickListener {
            answer?.let { ans ->
                viewModel.setAnswer(ans)
            }

            viewModel.goToNextQuestion()

            if(viewModel.isQuestionsFinished) {
                getResult(it)
            }

            radioGroup.clearCheck()
        }


        binding.submitButton.setOnClickListener {
            answer?.let { ans ->
                viewModel.setAnswer(ans)
            }
            getResult(it)
        }

    }

    private fun getResult(view: View) {
        if(viewModel.isPassed()) {
            view.findNavController().navigate(com.zeko.triviaapp.R.id.action_gameFragment_to_gameWonFragment)
        } else {
            view.findNavController().navigate(com.zeko.triviaapp.R.id.action_gameFragment_to_gameOverFragment)
        }
        viewModel.resetGame()
    }
}