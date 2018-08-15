package com.tommyputranto.testdriventutor.Login


/**
 * Created by Tommy Dwi Putranto on 15/08/18.
 */
interface LoginView {
    fun showErrorMessageForUserNamePassword()
    fun showErrorMessageForMaxLoginAttempt()
    fun showLoginSuccessMessage()
}