package com.utad.tarea_database_fortiniteservice.services.fortiniteTracker

import com.utad.tarea_database_fortiniteservice.models.ForniteUsers
import io.reactivex.Observable

class ForniteRepository  {

    private val UserApi = ForniteApi.start()

    companion object {
        @Volatile
        private var INSTANCE: ForniteRepository? = null

        fun getInstance(): ForniteRepository = INSTANCE
            ?: synchronized(this){
                INSTANCE
                    ?: ForniteRepository()
                        .also { INSTANCE = it}
            }
        fun destroyInstance(){
            INSTANCE = null
        }
    }



    fun getUserFortinite(description: String, page: String): Observable<List<ForniteUsers>> {

        return UserApi.loadData(description, page)

    }
}