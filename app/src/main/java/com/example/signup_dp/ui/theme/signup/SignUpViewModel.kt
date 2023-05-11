package com.example.signup_dp.ui.theme.signup

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SignUpViewModel : ViewModel() {

    private val viewModelState = MutableStateFlow(SignUpViewModelUI())
    private var countDownTimer: CountDownTimer? = null

    val uiState = viewModelState
        .map { it.toUiState() }
        .stateIn(viewModelScope, SharingStarted.Eagerly, viewModelState.value.toUiState())

    fun onRegisteredEmailOrNumberEntered(registerEmailOrNumber: String?) {
        viewModelState.update {
            it.copy(
                registerEmailOrNumber = registerEmailOrNumber
            )
        }
    }

    fun onOtpEntered(otpNumber: String?) {
        viewModelState.update {
            it.copy(
                otpNumber = otpNumber
            )
        }
    }

    fun onUserNameEntered(name: String) {
        viewModelState.update {
            it.copy(
                userName = name

            )
        }
    }

    fun onPasswordEntered(password: String) {
        viewModelState.update {
            it.copy(
                password = password
            )
        }
    }

    fun onErrorShown() {
        viewModelState.update {
            it.copy(
                errorMessage = null,
            )
        }
    }

    fun validateRegisteredEmailOrNumber() {
        if (uiState.value.registerEmailOrNumber?.isEmpty() == true) {
            viewModelState.update {
                it.copy(
                    errorMessage = "Enter your registered email or number"
                )
            }
        } else {
            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(uiState.value.registerEmailOrNumber).matches()) {
                viewModelState.update {
                    it.copy(
                        errorMessage = "Enter a proper email format"
                    )
                }
            } else {
                onErrorShown()
            }
        }
    }

    private fun startCountDownTimer() {
        countDownTimer = object : CountDownTimer(120000, 1000) {
            override fun onTick(timeUntilFinished: Long) {
                val countDownTime = timeUntilFinished / 1000
                val formattedTime =
                    String.format("%02d:%02d", countDownTime / 60, countDownTime % 60)
                viewModelState.update {
                    it.copy(
                        timeLeft = formattedTime
                    )
                }
            }

            override fun onFinish() {
                viewModelState.update {
                    it.copy(
                        timeLeft = "00:00",
                    )
                }
            }
        }
        (countDownTimer as CountDownTimer).start()

    }
}




data class SignUpViewModelUI(
    val isLoading: Boolean = false,
    val userName: String? = "",
    val registerEmailOrNumber: String? = "",
    val otpNumber: String? = "",
    val password: String? = "",
    val lastUpdate: Long? = System.currentTimeMillis(),
    val errorMessage: String? = "",
    val timeLeft: String = 6000.toString(),
) {
    fun toUiState(): SignUpViewModelState {
        return SignUpViewModelState(
            isLoading = isLoading,
            lastUpdate = lastUpdate,
            userName = userName,
            registerEmailOrNumber = registerEmailOrNumber,
            otpNumber = otpNumber,
            password = password,
            errorMessage = errorMessage,
            timeLeft = timeLeft,
        )
    }
}

data class SignUpViewModelState(
    val isLoading: Boolean,
    val lastUpdate: Long?,
    val registerEmailOrNumber: String?,
    val otpNumber: String?,
    val userName: String?,
    val password: String?,
    val errorMessage: String?,
    val timeLeft: String,
)