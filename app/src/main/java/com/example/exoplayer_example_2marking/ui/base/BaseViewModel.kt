package com.example.exoplayer_example_2marking.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {
    protected val compositeDisposable = CompositeDisposable()

    protected val _dataLoading = MutableLiveData<Event<Boolean>>
    val dataLoading: LiveData<Event<Boolean>> = _dataLoading

    protected val _error = MutableLiveData<Event<Throwable>>()
    val error: LiveData<Event<Throwable>> = _error

    open fun initialized(){

    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

//    protected val _dataLoading = MutableLiveData<Event<Boolean>>
}