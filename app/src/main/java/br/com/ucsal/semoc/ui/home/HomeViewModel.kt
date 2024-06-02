package br.com.ucsal.semoc.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "A Semana de Mobilização Científica (SEMOC) é uma atividade promovida anualmente pela Universidade Católica do Salvador desde 1998, organizada e executada democraticamente pelos diversos segmentos da comunidade acadêmica (professores, alunos e funcionários).\n" +
                "\n" +
                "Integrando a programação regular de atividades do calendário acadêmico da UCSal, a SEMOC tem gerado importantes desdobramentos para o fortalecimento da ambiência acadêmica, dentre os quais se inclui o estímulo à sensibilização e mobilização dos diversos segmentos da comunidade universitária, com repercussões na produção e socialização da pesquisa científica, no intercâmbio de atividades culturais e na articulação intercampi e interinstitucional de docentes, discentes, funcionários e pesquisadores em torno das temáticas selecionadas.\n" +
                "\n" +
                "Dentre seus principais objetivos, a SEMOC pretende estimular e socializar as iniciativas no campo da pesquisa científica, contribuir para a conscientização da comunidade acadêmica sobre a importância da função pesquisa para a Universidade, promover o intercâmbio intra e interinstitucional em torno da produção do conhecimento, e fomentar a difusão e o fortalecimento da diversidade científica no Estado da Bahia, como também no âmbito nacional e internacional."
    }
    val text: LiveData<String> = _text
}