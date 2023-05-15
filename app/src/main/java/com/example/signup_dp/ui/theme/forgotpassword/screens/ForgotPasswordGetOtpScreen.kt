package com.example.signup_dp.ui.theme.forgotpassword.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup_dp.R

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GetOtpScreenPreview() {
    GetOtpScreen(
        "", {},false, true, {}, {}
    )
}

@Composable
fun DigivalLogo() {
    Image(
        painter = painterResource(id = R.drawable.ic_logo),
        contentDescription = stringResource(id = R.string.app_name),
        modifier = Modifier
            .padding(40.dp)
            .size(200.dp, 40.dp)
    )
}

@Composable
fun ForgotPasswordText() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            color = Color.DarkGray,
            text = "Forgotten Password",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterRegisteredEmailOrNumber(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            style = TextStyle(fontSize = 14.sp),
            color = Color.DarkGray,
            text = "Enter Registered Email ID / Mobile Number"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            value = registeredEmailOrNumber,
            onValueChange = onRegisteredEmailOrNumberEntered,
            label = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            }
        )
    }
}

@Composable
fun GetOtpButton(
    isEnabled: Boolean,
    onGetOtpButtonClicked: () -> Unit
) {
    OutlinedButton(
        enabled = isEnabled,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = { onGetOtpButtonClicked()
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
            text = "Get Otp"
        )
    }
}

@Composable
fun HelpText(
    onHelpClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier = Modifier.clickable { onHelpClicked() },
            style = TextStyle(fontWeight = FontWeight.Medium),
            text = "Help?"
        )
    }
}

@Composable
fun GetOtpBox(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
    isEnabled: Boolean,
    onHelpClicked: () -> Unit,
    onGetOtpButtonClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        ForgotPasswordText()
        EnterRegisteredEmailOrNumber(
            registeredEmailOrNumber = registeredEmailOrNumber,
            onRegisteredEmailOrNumberEntered = onRegisteredEmailOrNumberEntered
        )
        GetOtpButton(
            isEnabled = isEnabled,
            onGetOtpButtonClicked = onGetOtpButtonClicked
        )
        HelpText(onHelpClicked)
    }
}

@Composable
fun GetOtpScreen(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
    isLoading: Boolean = false,
    isEnabled: Boolean,
    onHelpClicked: () -> Unit,
    onGetOtpButtonClicked: () -> Unit
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
            GetOtpBox(
                registeredEmailOrNumber = registeredEmailOrNumber,
                onRegisteredEmailOrNumberEntered = onRegisteredEmailOrNumberEntered,
                isEnabled = isEnabled,
                onHelpClicked = onHelpClicked,
                onGetOtpButtonClicked = onGetOtpButtonClicked
            )
        }
    }
}