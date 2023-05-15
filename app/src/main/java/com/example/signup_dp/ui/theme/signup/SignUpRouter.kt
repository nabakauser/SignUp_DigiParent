package com.example.signup_dp.ui.theme.signup

import SignUpScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.signup_dp.ui.theme.signup.screens.EnterOtpScreen
import com.example.signup_dp.ui.theme.signup.screens.GetOtpScreen
import com.example.signup_dp.ui.theme.signup.screens.LoginScreen


@Composable
fun SignUpRouter(
    signUpViewModel: SignUpViewModel
) {
    val uiState by signUpViewModel.uiState.collectAsState()
    SignUpScreenRouter(uiState = uiState, viewModel = signUpViewModel)

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

@Composable
fun SignUpScreenRouter(
    uiState: SignUpUiState,
    viewModel: SignUpViewModel
) {
    when (uiState) {
        is SignUpUiState.GetOtp -> {
            GetOtpScreen(
                registeredEmailOrNumber = uiState.registerEmailOrNumber,
                onRegisteredEmailOrNumberEntered = { viewModel.onRegisteredEmailOrNumberEntered(it) },
                isLoading = uiState.isLoading,
                isGetOtpEnabled = uiState.isGetOtpEnabled,
                onHelpClicked = {},
                onGetOtpButtonClicked = {viewModel.navigateToEnterOtpScreen()}
            )
        }

        is SignUpUiState.EnterOtp -> {
            EnterOtpScreen(
                otp = uiState.otp,
                onOtpEntered = {viewModel.onOtpEntered(it)},
                isLoading = uiState.isLoading,
                isProceedEnabled = uiState.isProceedEnabled,
                onHelpClicked = {},
                onResendOtpClicked = {},
                onProceedButtonClicked = {viewModel.onProceedClicked()}
            )
        }

        is SignUpUiState.SignUp -> {
            SignUpScreen(
                registeredEmailOrNumber = uiState.registerEmailOrNumber,
                onRegisteredEmailOrNumberEntered = { viewModel.onRegisteredEmailOrNumberEntered(it) },
                name = viewModel.userName,
                onNameEntered = { viewModel.onUserNameEntered(it)},
                password = viewModel.password,
                onPasswordEntered = {viewModel.onPasswordEntered(it)},
                isLoading = uiState.isLoading,
                isEnabled = uiState.isEnabled,
                onHelpClicked = {},
                onSignUpClicked = {viewModel.onSignUpClicked()},
                onLoginButtonClicked = {viewModel.navigateToLoginActivity()}
            )
        }

        is SignUpUiState.Login -> {
            LoginScreen(
                registeredEmailOrNumber = uiState.registerEmailOrNumber,
                onRegisteredEmailOrNumberEntered = { viewModel.onRegisteredEmailOrNumberEntered(it) },
                password = viewModel.password,
                onPasswordEntered = {viewModel.onPasswordEntered(it)},
                isLoading = uiState.isLoading,
                isEnabled = uiState.isEnabled,
                onSignUpClicked = {viewModel.navigateToSignUpScreen()},
                onLoginClicked = {},
                onHelpClicked = {},
                onForgotPasswordClicked = {}
            )
        }
        else -> {

        }
    }
}