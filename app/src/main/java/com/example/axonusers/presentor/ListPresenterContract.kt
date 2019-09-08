package com.example.axonusers.presentor

import com.example.axonusers.data.Results

interface ListPresenterContract {
    interface ListPresenter{
        suspend fun getData():List<Results>

        fun onViewDestroy()

        fun setView(view: ListView)
    }

    interface ListView: BaseView{
        //TODO add some extra func for view
    }
}