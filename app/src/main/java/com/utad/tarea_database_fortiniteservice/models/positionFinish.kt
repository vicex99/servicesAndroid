package com.utad.tarea_database_fortiniteservice.models

class positionFinish (
    score: dataRank?,
    matches: dataRank?,
    kills: dataRank?
) {

    companion object {
        @Volatile
        private var INSTANCE: positionFinish? = null

        fun getInstance(): positionFinish = INSTANCE
            ?: synchronized(this) {
                INSTANCE
                    ?: positionFinish(
                        null, null, null
                    ).also { INSTANCE = it }
            } as positionFinish

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
