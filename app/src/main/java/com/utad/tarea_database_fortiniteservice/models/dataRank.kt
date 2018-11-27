package com.utad.tarea_database_fortiniteservice.models

class dataRank (
    title: String?,
    value: String?,
    rank: String?
){

    companion object {
        @Volatile
        private var INSTANCE: dataRank? = null

        fun getInstance(): dataRank = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: dataRank(null,null, null
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}