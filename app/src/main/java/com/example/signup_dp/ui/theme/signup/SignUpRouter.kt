package com.example.signup_dp.ui.theme.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue


@Composable
fun SignUpRouter(
    signUpViewModel: SignUpViewModel
) {
//    val uiState by signUpViewModel.uiState.collectAsState()
//    SignUpScreen(
//        userName = uiState.userName,
//        registeredEmailOrNumber = uiState.registerEmailOrNumber,
//        password = uiState.password,
//        onRegisteredEmailOrNumberEntered = {signUpViewModel.onRegisteredEmailOrNumberEntered(it)},
//        onUserNameEntered = {signUpViewModel.onUserNameEntered(it)},
//        onPasswordEntered = {signUpViewModel.onPasswordEntered(it)},
//        errorMessage = uiState.errorMessage,
//        onErrorShown = { signUpViewModel.onErrorShown()},
//    )
}