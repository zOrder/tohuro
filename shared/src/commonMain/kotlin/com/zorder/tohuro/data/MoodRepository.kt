package com.zorder.tohuro.data

import com.zorder.tohuro.model.Mood

class MoodRepository {
    private val moods = mutableListOf<Mood>()

    init {
        moods.addAll(
            listOf(
                Mood("1", "good"),
                Mood("1", "bad"),
            )
        )
    }

    fun getMood(id: String): Mood? {
        return moods.firstOrNull { it.id == id }
    }

    fun getMoods():List<Mood>{
        return moods
    }
}