package com.example.signup_dp.ui.theme.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val viewModelState = MutableStateFlow(
        SignUpViewModelState(
            signUpMode = SignUpMode.GET_OTP,
            isLoading = false,
            isEnabled = false,
            showErrorText = false
        )
    )
    private val toastMessage: MutableState<String> = mutableStateOf("")

    var userName by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set


    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())


    fun onRegisteredEmailOrNumberEntered(registeredEmailOrNumber: String) {
        validateEnteredEmailOrNumber()
        viewModelState.update {
            it.copy(
                registerEmailOrNumber = registeredEmailOrNumber
            )
        }
    }

    fun onOtpEntered(otpNumber: String) {
        viewModelState.update {
            it.copy(
                otp = otpNumber,
            )
        }
        validateEnteredOtp()
    }

    fun onUserNameEntered(name: String) {
        viewModelState.update { it.copy(isLoading = false) }
        this.userName = name
    }

    fun onPasswordEntered(password: String) {
        viewModelState.update { it.copy(isLoading = false) }
        this.password = password
    }

    private fun validateEnteredEmailOrNumber(): Boolean {
        val registerId = viewModelState.value.registerEmailOrNumber
        val isValidNumbers = registerId.isNotEmpty() && registerId.isDigitsOnly()
        val isValidEmail = registerId.isNotEmpty() && (android.util.Patterns.EMAIL_ADDRESS.matcher(registerId).matches())

        viewModelState.value.isGetOtpEnabled = isValidNumbers || isValidEmail
        return isValidNumbers || isValidEmail
    }

    private fun validateEnteredOtp(): Boolean {
        val otp = viewModelState.value.otp
        val isValidOtp = otp.isDigitsOnly() && otp.isNotEmpty() && otp.length == 6

        viewModelState.value.isProceedEnabled = isValidOtp
        viewModelState.value.showErrorText = !isValidOtp

        return isValidOtp
    }

    fun onProceedClicked() {
            navigateToSignUpScreen()
    }

    fun navigateToEnterOtpScreen() {
        viewModelState.update {
            it.copy(
                signUpMode = SignUpMode.ENTER_OTP
            )
        }
    }

    fun navigateToSignUpScreen() {
        viewModelState.update {
            it.copy(
                signUpMode = SignUpMode.SIGNUP
            )
        }
    }

    fun navigateToLoginActivity() {
        viewModelState.update {
            it.copy(
                signUpMode = SignUpMode.LOGIN
            )
        }
    }

    fun onSignUpClicked() {
        if (validateEnteredEmailOrNumber() && userName.isNotEmpty() && password.isNotEmpty()) {
            navigateToLoginActivity()
        }
    }


    private fun showToast(message: String) {
        toastMessage.value = message
    }
}

sealed class SignUpUiState {
    data class GetOtp(
        val registerEmailOrNumber: String,
        val isLoading: Boolean,
        val isGetOtpEnabled: Boolean,
    ) : SignUpUiState()

    data class EnterOtp(
        val otp: String,
        val isLoading: Boolean,
        val isProceedEnabled: Boolean,
        val showErrorText: Boolean
    ) : SignUpUiState()

    data class SignUp(
        val registerEmailOrNumber: String,
        val isLoading: Boolean,
        val isEnabled: Boolean,
        val showErrorText: Boolean
    ) : SignUpUiState()

    data class Login(
        val registerEmailOrNumber: String,
        val isLoading: Boolean,
        val isEnabled: Boolean,
        val showErrorText: Boolean
    ) : SignUpUiState()

    object Success : SignUpUiState()
}

data class SignUpViewModelState(
    val signUpMode: SignUpMode? = null,
    val isLoading: Boolean = false,

    val registerEmailOrNumber: String = "",
    var isGetOtpEnabled: Boolean = false,

    val otp: String = "",
    var isProceedEnabled: Boolean = false,
    var showErrorText: Boolean = false,

    var isEnabled: Boolean = true,
) {
    fun toUiState(): SignUpUiState {
        return when (signUpMode) {
            SignUpMode.GET_OTP -> SignUpUiState.GetOtp(registerEmailOrNumber, isLoading, isGetOtpEnabled)
            SignUpMode.ENTER_OTP -> SignUpUiState.EnterOtp(otp, isLoading, isProceedEnabled, showErrorText)
            SignUpMode.SIGNUP -> SignUpUiState.SignUp(registerEmailOrNumber,isLoading, isEnabled, showErrorText)
            SignUpMode.LOGIN -> SignUpUiState.Login(registerEmailOrNumber, isLoading, isEnabled, showErrorText)
            else -> {
                SignUpUiState.GetOtp(registerEmailOrNumber, isLoading, isEnabled)
            } // add success object to go to logged in screen
        }
    }
}

enum class SignUpMode {
    GET_OTP,
    ENTER_OTP,
    SIGNUP,
    LOGIN,
}
