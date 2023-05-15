package com.example.signup_dp.ui.theme.forgotpassword.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup_dp.R
import com.example.signup_dp.ui.theme.signup.screens.SignUpText

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    CreateNewPasswordScreen("", {}, "", {}, false, true, {}, {})
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewPassword(
    password: String,
    onPasswordEntered: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 14.sp),
            color = Color.DarkGray,
            text = "New Password"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = onPasswordEntered,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            label = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility })
                {
                    if (!passwordVisibility) {
                        Icon(
                            painterResource(id = R.drawable.ic_visibility),
                            contentDescription = "not visible",
                            tint = Color.Gray
                        )
                    } else {
                        Icon(
                            painterResource(id = R.drawable.ic_visibility),
                            contentDescription = "visible",
                            tint = Color.Black
                        )
                    }
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmYourPassword(
    confirmPassword: String,
    onConfirmPasswordEntered: (String) -> Unit
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 14.sp),
            color = Color.DarkGray,
            text = "Confirm Password"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = confirmPassword,
            onValueChange = onConfirmPasswordEntered,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            label = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisibility = !passwordVisibility })
                {
                    if (!passwordVisibility) {
                        Icon(
                            painterResource(id = R.drawable.ic_visibility),
                            contentDescription = "not visible",
                            tint = Color.Gray
                        )
                    } else {
                        Icon(
                            painterResource(id = R.drawable.ic_visibility),
                            contentDescription = "visible",
                            tint = Color.Black
                        )
                    }
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(), // to hide passwords
        )

    }
}


@Composable
fun ChangePasswordButton(
    isEnabled: Boolean,
    onChangePasswordClicked: () -> Unit
) {
    OutlinedButton(
        enabled = isEnabled,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = {
            onChangePasswordClicked()
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
            text = "Change Password"
        )
    }
}


@Composable
fun CreateNewPasswordBox(
    password: String,
    onPasswordEntered: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordEntered: (String) -> Unit,
    isEnabled: Boolean,
    onHelpClicked: () -> Unit,
    onChangePasswordClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
    ) {
        SignUpText()
        NewPassword(
            password = password,
            onPasswordEntered = onPasswordEntered
        )
        ConfirmYourPassword(
            confirmPassword = confirmPassword,
            onConfirmPasswordEntered = onConfirmPasswordEntered
        )
        ChangePasswordButton(
            isEnabled = isEnabled,
            onChangePasswordClicked = onChangePasswordClicked
        )
        HelpText(onHelpClicked)
        Spacer(modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun CreateNewPasswordScreen(
    password: String,
    onPasswordEntered: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordEntered: (String) -> Unit,
    isLoading: Boolean = false,
    isEnabled: Boolean,
    onHelpClicked: () -> Unit,
    onChangePasswordClicked: () -> Unit
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
                DigivalLogo()
            }
            CreateNewPasswordBox(
                password = password,
                onPasswordEntered = onPasswordEntered,
                confirmPassword = confirmPassword,
                onConfirmPasswordEntered = onConfirmPasswordEntered,
                isEnabled = isEnabled,
                onHelpClicked = onHelpClicked,
                onChangePasswordClicked = onChangePasswordClicked
            )
        }
    }
}