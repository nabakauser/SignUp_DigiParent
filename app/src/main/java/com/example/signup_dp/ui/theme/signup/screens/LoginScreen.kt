package com.example.signup_dp.ui.theme.signup.screens

import SetYourPassword
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup_dp.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login() {
    LoginScreen("",{},"",{}, true, true,{}, {}, {},{})
}

@Composable
fun ForgotPasswordText(
    onForgotPasswordClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier = Modifier.clickable {
                onForgotPasswordClicked()
            },
            style = TextStyle(fontSize = 12.sp),
            text = "Forgot Password?"
        )
    }
}

@Composable
fun LoginButton(
    onLoginClicked: () -> Unit,
    isEnabled: Boolean,
) {
    OutlinedButton(
        enabled = isEnabled,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = {
            onLoginClicked()
        },
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.digi_blue))
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            text = "Log In"
        )
    }
}

@Composable
fun NewUserText() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
    ) {
        Text(text = "New User?")
        Spacer(modifier = Modifier.padding(2.dp))
    }
}

@Composable
fun SignUpButton(
    onSignUpClicked : () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        onClick = onSignUpClicked,
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(Color.White),
        border = BorderStroke(1.dp, colorResource(id = R.color.digi_blue))
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                color = colorResource(id = R.color.digi_blue),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            text = "Sign Up"
        )
    }
}

@Composable
fun LoginBox(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
    password: String,
    onPasswordEntered: (String) -> Unit,
    isEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    onLoginClicked: () -> Unit,
    onHelpClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        EnterRegisteredEmailOrNumber(
            registeredEmailOrNumber = registeredEmailOrNumber,
            onRegisteredEmailOrNumberEntered = onRegisteredEmailOrNumberEntered
        )
        SetYourPassword(
            text = "Enter Password",
            password = password,
            onPasswordEntered = onPasswordEntered
        )
        LoginButton(
            onLoginClicked = onLoginClicked,
            isEnabled = isEnabled)
        ForgotPasswordText(
            onForgotPasswordClicked = onForgotPasswordClicked
        )
        HelpText(onHelpClicked)
        Spacer(modifier = Modifier.padding(top = 10.dp))
        NewUserText()
        SignUpButton(
            onSignUpClicked = onSignUpClicked
        )

    }
}

@Composable
fun LoginScreen(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
    password: String,
    onPasswordEntered: (String) -> Unit,
    isLoading: Boolean = false,
    isEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    onLoginClicked: () -> Unit,
    onHelpClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.digi_blue)),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                com.example.signup_dp.ui.theme.forgotpassword.screens.DigivalLogo()
            }
            LoginBox(
                registeredEmailOrNumber = registeredEmailOrNumber,
                onRegisteredEmailOrNumberEntered = onRegisteredEmailOrNumberEntered,
                password = password,
                onPasswordEntered = onPasswordEntered,
                isEnabled = isEnabled,
                onSignUpClicked = onSignUpClicked,
                onHelpClicked = onHelpClicked,
                onForgotPasswordClicked = onForgotPasswordClicked,
                onLoginClicked = onLoginClicked
            )
        }
    }
}