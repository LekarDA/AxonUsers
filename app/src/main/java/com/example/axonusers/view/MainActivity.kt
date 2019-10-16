package com.example.axonusers.view

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.axonusers.App
import com.example.axonusers.R
import com.example.axonusers.presentor.ListPresenterContract
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : CoroutineAppCompatActivity(), OnUserClickListener, ListPresenterContract.ListView {


    private lateinit var  layoutManager : LinearLayoutManager
    private lateinit var adapter : UsersAdapter

    @Inject
    lateinit var presenter: ListPresenterContract.ListPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.injectActivity(this)
        initList()
        launch { adapter.setData(presenter.getData()) }
    }

    private fun initList() {
        layoutManager = LinearLayoutManager(this)
        listOfUsers.layoutManager = layoutManager
        adapter = UsersAdapter()
        listOfUsers.adapter = adapter
        adapter.setItemClickListener(this)
    }

    override fun onUserClick(position: Int) {
    }
}
