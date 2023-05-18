package com.zeko.triviaapp.ui.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.ceil
import kotlin.math.floor

class MainViewModel : ViewModel() {
    private var _score = 0
    val score: Int
    get() = _score

    private val _index = MutableLiveData<Int>(0)
    val index: LiveData<Int>
        get() = _index

    val questions = listOf(
        "what is the addition of 5 + 4?",
        "what is the subtraction of 5 - 4?",
        "what is the multiplication of 5 * 4?"
    )

    val choices = listOf(
        listOf("2", "9", "1", "20"),
        listOf("2", "9", "1", "20"),
        listOf("2", "9", "1", "20")
    )

    private val answers = listOf("9", "1", "20")

    private var _isQuestionsFinished = false
    val isQuestionsFinished
        get() = _isQuestionsFinished

    public fun goToNextQuestion() {
        if (_index.value == questions.size - 1) {
            _isQuestionsFinished = true
        } else {
            _index.value = _index.value?.plus(1)
        }


    }

    public fun isPassed(): Boolean {
        return _score > floor((questions.size / 2).toDouble())
    }

    public fun resetGame() {
        _score = 0
        _index.value = 0
    }

    public fun setAnswer(answer: String) {
        if(answer == _index.value?.let { answers[it] }) {
            _score++
        }
    }

}