package com.utad.tarea_database_fortiniteservice.models

class FortiniteUsers (
stats: Stats?
){

    companion object {
        @Volatile
        private var INSTANCE: FortiniteUsers? = null

        fun getInstance(): FortiniteUsers = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: FortiniteUsers(null
                    ).also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }
}