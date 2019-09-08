package com.example.axonusers.presentor

import com.example.axonusers.data.Results
import com.example.axonusers.repository.Repository

class ListPresenter(private val repository : Repository) :BasePresenter<ListPresenterContract.ListView>(), ListPresenterContract.ListPresenter {

    override fun setView(view: ListPresenterContract.ListView) = viewSetter(view)

    override suspend fun getData():List<Results> {
        return repository.getUsersList()
    }


    override fun onViewDestroy() {
        super.destroy()
    }

}