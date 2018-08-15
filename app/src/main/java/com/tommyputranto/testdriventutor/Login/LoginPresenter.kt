package com.tommyputranto.testdriventutor.Login

import com.tommyputranto.testdriventutor.MainActivity


/**
 * Created by Tommy Dwi Putranto on 15/08/18.
 */
class LoginPresenter(private var loginView: LoginView?) {

    private val MAX_LOGIN_ATTEMPT: Int = 3
    private var loginAttempt: Long = 0


    fun incrementLoginAttemps(): Long {
        loginAttempt += 1
        return loginAttempt
    }

    fun isLoginAttemptExceed(): Boolean {
        return loginAttempt >= MAX_LOGIN_ATTEMPT
    }

    fun doLogin(username: String, password: String) {
        if(isLoginAttemptExceed()){
            loginView?.showErrorMessageForMaxLoginAttempt()
            return
        }
        if (username.equals("tommy") && password.equals("test")){
            loginView?.showLoginSuccessMessage()
            return
        }
        incrementLoginAttemps()
        loginView?.showErrorMessageForUserNamePassword()
    }

}