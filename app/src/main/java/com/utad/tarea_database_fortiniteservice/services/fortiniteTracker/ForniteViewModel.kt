package com.utad.tarea_database_fortiniteservice.services.fortiniteTracker

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.utad.tarea_database_fortiniteservice.models.ForniteUsers

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.internal.platform.ConscryptPlatform

class ForniteViewModel {

    private val fortiniteRepository = ForniteRepository.getInstance()
    var liveData = MutableLiveData<List<ForniteUsers>>()
    var myRepository = ForniteRepository.getInstance()

    fun getData(platform: String, user: String) {

        fortiniteRepository.getUserFortinite(platform, user)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<ForniteUsers>> {

                override fun onSubscribe(d: Disposable) {
                }

                //En este metodo me llegan los cambios.
                override fun onNext(changes: List<ForniteUsers>) {
                    liveData.postValue(changes)
                }

                override fun onError(e: Throwable) {
                    Log.d("ServiceFail", "err: " + e.localizedMessage)
                }

                override fun onComplete() {
                    Log.d("ServiceComplete", "datos descargados")
                }
            })
    }
}