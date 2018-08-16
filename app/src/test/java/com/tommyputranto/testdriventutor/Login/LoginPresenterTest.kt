package com.tommyputranto.testdriventutor.Login

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.After
import org.junit.Assert
import org.junit.Before

import org.junit.Test
import kotlin.math.log

/**
 * Created by Tommy Dwi Putranto on 15/08/18.
 */
class LoginPresenterTest {

    @Test
    fun checkIfLoginAttemptIsExceed(){
        val loginView : LoginView = mock()
        val loginPresenter = LoginPresenter(loginView)
        Assert.assertEquals(1, loginPresenter.incrementLoginAttemps())
        Assert.assertEquals(2, loginPresenter.incrementLoginAttemps())
        //Assert.assertEquals(3, loginPresenter.incrementLoginAttemps())
        Assert.assertTrue(loginPresenter.isLoginAttemptExceed())
    }

    @Test
    fun checkIfLoginAttemptIsNotExceed(){
        val loginView: LoginView = mock()
        val loginPresenter = LoginPresenter(loginView)
        Assert.assertFalse(loginPresenter.isLoginAttemptExceed())
    }


    @Test
    fun checkIfUsernameAndPasswordIsCorrect(){
        val loginView: LoginView = mock()
        val loginPresenter = LoginPresenter(loginView)
        loginPresenter.doLogin("tommy", "test")
        verify(loginView).showLoginSuccessMessage()
    }

}