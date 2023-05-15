package com.example.signup_dp.ui.theme.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

class SignUpActivity : ComponentActivity() {

    private val signUpViewModel: SignUpViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpRouter(signUpViewModel = signUpViewModel)
        }
    }
}












































