package br.com.ucsal.semoc.ui.talk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ucsal.semoc.model.Talk

class TalkViewModel : ViewModel() {

    private val _allTalks = MutableLiveData<List<Talk>>()
    val allTalks: LiveData<List<Talk>> = _allTalks

    fun search(query: String): LiveData<List<Talk>> {
        val result = _allTalks.value?.filter { it.nome.contains(query, ignoreCase = true) }
        return MutableLiveData(result)
    }
}