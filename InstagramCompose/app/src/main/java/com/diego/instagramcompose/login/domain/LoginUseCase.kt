package com.diego.instagramcompose.login.domain

import com.diego.instagramcompose.login.data.LoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository){
//    private val repository: LoginRepository = LoginRepository()


    suspend operator fun invoke(user:String,password:String):Boolean{
        return  repository.doLogin(user,password)
    }

}