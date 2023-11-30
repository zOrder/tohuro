package com.zorder.tohuro.list

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.zorder.tohuro.data.MoodRepository
import com.zorder.tohuro.model.Mood
import kotlinx.coroutines.launch

class MoodListScreenModel(
    private val moodsRepository: MoodRepository
) : StateScreenModel<MoodListScreenModel.State>(State.Init)
{
    sealed class State {
        data object Init : State()
        data object Loading : State()
        data object Error : State()
        data class Result(val moods: List<Mood>) : State()
    }

    init {
        getMoods()
    }

    private fun getMoods(){
        screenModelScope.launch {
            mutableState.value = State.Loading
            mutableState.value = State.Result(moods = moodsRepository.getMoods())
        }
    }
}