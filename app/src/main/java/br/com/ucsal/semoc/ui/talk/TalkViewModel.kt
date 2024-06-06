package br.com.ucsal.semoc.ui.talk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ucsal.semoc.model.Talk
import br.com.ucsal.semoc.repository.TalkRepository
import br.com.ucsal.semoc.utils.formatDateInUSFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TalkViewModel : ViewModel() {
    private val _talks = MutableLiveData<List<Talk>>()
    val talks: LiveData<List<Talk>> get() = _talks

    init {
        fetchTalks()
    }

    private fun fetchTalks() {
        val talkRepository = TalkRepository()
        talkRepository.getTalks().enqueue(object : Callback<List<Talk>> {
            override fun onResponse(call: Call<List<Talk>>, response: Response<List<Talk>>) {
                response.body()?.let {
                    _talks.value = it
                }
            }

            override fun onFailure(call: Call<List<Talk>>, t: Throwable) {
            }
        })
    }

    fun filterTalksByDate(date: String) {
        _talks.value = _talks.value?.filter { it.data == date.formatDateInUSFormat() }
    }

    fun resetTalks() {
        fetchTalks()
    }
}