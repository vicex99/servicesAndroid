package com.utad.tarea_database_fortiniteservice.models

class StatsUser (
    val score: dataRank?,
    val matches: dataRank?,
    val kills: dataRank?
) {

    companion object {
        @Volatile
        private var INSTANCE: StatsUser? = null

        fun getInstance(): StatsUser = INSTANCE
            ?: synchronized(this) {
                INSTANCE
                    ?: StatsUser(
                        null, null, null
                    ).also { INSTANCE = it }
            }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
