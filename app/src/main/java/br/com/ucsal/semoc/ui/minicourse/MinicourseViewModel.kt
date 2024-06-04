package br.com.ucsal.semoc.ui.minicourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class minicourseViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is minicourse Fragment"
    }
    val text: LiveData<String> = _text
}