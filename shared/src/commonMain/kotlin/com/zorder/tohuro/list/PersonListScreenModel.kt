package com.zorder.tohuro.list

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.zorder.tohuro.data.PersonRepository
import com.zorder.tohuro.model.Person
import kotlinx.coroutines.launch

class PersonListScreenModel(
    private val personRepository: PersonRepository
) : StateScreenModel<PersonListScreenModel.State>(State.Init) {

    sealed class State {
        data object Init : State()
        data object Loading : State()
        data object Error : State()
        data class Result(val persons: List<Person>) : State()
    }

    init {
        getPersons()
    }

    private fun getPersons() {
        screenModelScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result(persons = personRepository.getPosts())
        }
    }
}