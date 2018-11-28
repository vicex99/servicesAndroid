package com.utad.tarea_database_fortiniteservice.models

class StatsFornite (
    val p10: StatsUser?
){

    companion object {
        @Volatile
        private var INSTANCE: StatsFornite? = null

        fun getInstance(): StatsFornite = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: StatsFornite(null
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}