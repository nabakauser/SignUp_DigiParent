package com.example.signup_dp.ui.theme.signup.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
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
fun EnterOtpNumberPreview() {
    EnterOtpScreen("", {}, false, true, {}, {}, {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterOtpNumber(
    otp: String,
    onEnterOtp: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 14.sp),
            color = Color.DarkGray,
            text = "Enter OTP Number"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            value = otp,
            onValueChange = onEnterOtp,
            placeholder = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            }
        )
    }
}

@Composable
fun OtpErrorAlertMessage(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp),
    ) {
        Icon(
            modifier = Modifier.size(14.dp),
            imageVector = Icons.Default.Warning,
            tint = Color.Red,
            contentDescription = ""
        )
        Text(
            modifier = Modifier.padding(start = 5.dp),
            style = TextStyle(fontSize = 12.sp, color = Color.Red),
            text = "Please enter a valid OTP Number"
        )
    }
}

@Composable
fun ProceedButton(
    isProceedEnabled: Boolean,
    onProceedButtonClicked: () -> Unit
) {
    OutlinedButton(
        enabled = isProceedEnabled,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = { onProceedButtonClicked() },
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
            text = "Proceed"
        )
    }
}

@Composable
fun ResendOtpText(
    onResendOtpClicked : () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            modifier = Modifier.clickable {
                onResendOtpClicked()
            },
            style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.digi_blue),
            text = "Resend OTP"
        )
    }
}

@Composable
fun OtpTimer() {
    Row(
        modifier = Modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            color = Color.Red,
            text = "00:00"
        )
    }
}

@Composable
fun EnterOtpBox(
    otp: String,
    onOtpEntered: (String) -> Unit,
    isProceedEnabled: Boolean,
    onHelpClicked: () -> Unit,
    onResendOtpClicked: () -> Unit,
    onProceedButtonClicked: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        SignUpText()
        EnterOtpNumber(
            otp = otp,
            onEnterOtp = onOtpEntered
        )
        OtpErrorAlertMessage()
        ProceedButton(
            isProceedEnabled = isProceedEnabled,
            onProceedButtonClicked = onProceedButtonClicked
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ResendOtpText(
                onResendOtpClicked = onResendOtpClicked
            )
            OtpTimer()
        }
        HelpText(
            onHelpClicked = onHelpClicked
        )
    }
}

@Composable
fun EnterOtpScreen(
    otp: String,
    onOtpEntered: (String) -> Unit,
    isLoading: Boolean = false,
    isProceedEnabled: Boolean,
    onHelpClicked: () -> Unit,
    onResendOtpClicked: () -> Unit,
    onProceedButtonClicked: () -> Unit
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
            EnterOtpBox(
                otp = otp,
                onOtpEntered = onOtpEntered,
                isProceedEnabled = isProceedEnabled,
                onHelpClicked = onHelpClicked,
                onResendOtpClicked = onResendOtpClicked,
                onProceedButtonClicked = onProceedButtonClicked
            )
        }
    }
}
