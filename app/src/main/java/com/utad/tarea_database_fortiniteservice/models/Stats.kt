package com.utad.tarea_database_fortiniteservice.models

class Stats (
    p10: positionFinish?
){

    companion object {
        @Volatile
        private var INSTANCE: Stats? = null

        fun getInstance(): Stats = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: Stats(null
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}