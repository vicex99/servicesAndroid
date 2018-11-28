package com.utad.tarea_database_fortiniteservice.models

class dataRank (
    val title: String,
    val value: String,
    val rank: String
){

    companion object {
        @Volatile
        private var INSTANCE: dataRank? = null

        fun getInstance(): dataRank = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: dataRank(
                        null.toString(), null.toString(), null.toString()
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}