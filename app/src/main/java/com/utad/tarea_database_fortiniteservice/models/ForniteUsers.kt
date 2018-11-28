package com.utad.tarea_database_fortiniteservice.models

class ForniteUsers (
    val stats: StatsFornite?
){

    companion object {
        @Volatile
        private var INSTANCE: ForniteUsers? = null

        fun getInstance(): ForniteUsers = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: ForniteUsers(null
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}