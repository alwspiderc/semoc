package br.com.ucsal.semoc.ui.talk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class talkViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is talk Fragment"
    }
    val text: LiveData<String> = _text
}