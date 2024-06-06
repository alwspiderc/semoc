package br.com.ucsal.semoc.ui.minicourse

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ucsal.semoc.model.Minicourse
import br.com.ucsal.semoc.repository.MinicourseRepository
import br.com.ucsal.semoc.utils.formatDateInUSFormat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MinicourseViewModel : ViewModel() {

    private val _minicourse = MutableLiveData<List<Minicourse>>()
    val minicourse: LiveData<List<Minicourse>> get() = _minicourse

    init {
        fetch()
    }

    private fun fetch() {
        val Repository = MinicourseRepository()
        Repository.getMinicourses().enqueue(object : Callback<List<Minicourse>> {
            override fun onResponse(call: Call<List<Minicourse>>, response: Response<List<Minicourse>>) {
                response.body()?.let {
                    _minicourse.value = it
                }
            }

            override fun onFailure(call: Call<List<Minicourse>>, t: Throwable) {
            }
        })
    }

    fun filterByDate(date: String) {
        _minicourse.value = _minicourse.value?.filter { it.data == date.formatDateInUSFormat() }
    }

    fun reset() {
        fetch()
    }
}