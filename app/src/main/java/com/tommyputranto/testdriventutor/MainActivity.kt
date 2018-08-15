package com.tommyputranto.testdriventutor

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tommyputranto.testdriventutor.Login.LoginPresenter
import com.tommyputranto.testdriventutor.Login.LoginView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginView {
    var loginPresenter : LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializePresenter()
        initializeView()

    }

    private fun initializePresenter(){
        loginPresenter = LoginPresenter(this)
    }

    private fun initializeView(){

        login.setOnClickListener {
            loginPresenter?.doLogin(username.text.toString(), password.text.toString())
        }
    }

    override fun showErrorMessageForUserNamePassword() {
        Toast.makeText(applicationContext,"Please check Username and Password", Toast.LENGTH_SHORT).show()
    }

    override fun showErrorMessageForMaxLoginAttempt() {
        Toast.makeText(applicationContext,"You Have exceeded MAX Attempt", Toast.LENGTH_SHORT).show()
    }

    override fun showLoginSuccessMessage() {
        Toast.makeText(applicationContext,"Login Successfully", Toast.LENGTH_SHORT).show()
    }

}



