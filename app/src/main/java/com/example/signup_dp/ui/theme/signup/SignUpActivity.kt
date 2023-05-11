package com.example.signup_dp.ui.theme.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup_dp.R

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GetOtpScreenPreview() {
    GetOtpScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EnterOtpNumberPreview() {
    EnterOtpScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Login() {
    LoginScreen()
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
fun SignUpText() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            color = Color.DarkGray,
            text = "New Sign Up",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterRegisteredEmailOrNumber() {
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
            value = "",
            onValueChange = { it },
            label = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterOtpNumber() {
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
            value = "",
            onValueChange = { it },
            label = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterName() {
    Column(
        modifier = Modifier
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(fontSize = 14.sp),
            color = Color.DarkGray,
            text = "Enter Your Name"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.LightGray
            ),
            value = "",
            onValueChange = { it },
            label = {
                Text(
                    color = Color.LightGray,
                    text = "Type Here"
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetYourPassword(
//    password : String?,
//    onPasswordEntered: () -> Unit
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
            text = "Set Your Password"
        )
        Spacer(modifier = Modifier.padding(2.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "1234",
            onValueChange = { it },
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
fun SignUpScreenButton(text: String) {
    OutlinedButton(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = {/*onProceedClicked()*/ },
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
            text = text
        )
    }
}

@Composable
fun HelpText() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            style = TextStyle(fontWeight = FontWeight.Medium),
            text = "Help?"
        )
    }
}

@Composable
fun ResendOtpText() {
    Row(
        modifier = Modifier
            .padding(10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
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
fun AlreadyUser() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
    ) {
        Text(text = "Already User?")
        Spacer(modifier = Modifier.padding(2.dp))
        LoginButton()
    }
}

@Composable
fun ForgotPasswordText() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            style = TextStyle(fontSize = 12.sp),
            text = "Forgot Password?"
        )
    }
}

@Composable
fun LoginButton() {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {/*onLoginClicked()*/ },
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.teal_200)),
        border = BorderStroke(1.dp, colorResource(id = R.color.digi_blue))
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                color = colorResource(id = R.color.digi_blue),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            text = "Log In"
        )
    }
}

@Composable
fun NewUser() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
    ) {
        Text(text = "New User?")
        Spacer(modifier = Modifier.padding(2.dp))
        SignUpButton()
    }
}

@Composable
fun SignUpButton() {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {/*onSignUpClicked()*/ },
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.teal_200)),
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
fun GetOtpBox() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        SignUpText()
        EnterRegisteredEmailOrNumber()
        SignUpScreenButton("Get OTP")
        HelpText()
    }
}

@Composable
fun GetOtpScreen() {
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
            GetOtpBox()

        }
    }
}

@Composable
fun EnterOtpBox() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        SignUpText()
        EnterOtpNumber()
        SignUpScreenButton("Proceed")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ResendOtpText()
            OtpTimer()
        }
        HelpText()
    }
}

@Composable
fun EnterOtpScreen() {
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
            EnterOtpBox()

        }
    }
}

@Composable
fun SignUpBox() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
    ) {
        SignUpText()
        EnterRegisteredEmailOrNumber()
        EnterName()
        SetYourPassword()
        SignUpScreenButton("Sign Up")
        HelpText()
        Spacer(modifier = Modifier.padding(top = 10.dp))
        AlreadyUser()
    }
}

@Composable
fun SignUpScreen() {
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
            SignUpBox()

        }
    }
}

@Composable
fun LoginBox() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White),
        modifier = Modifier
            .fillMaxSize(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp)
    ) {
        EnterRegisteredEmailOrNumber()
        SetYourPassword()
        SignUpScreenButton("Log In")
        ForgotPasswordText()
        HelpText()
        Spacer(modifier = Modifier.padding(top = 10.dp))
        NewUser()
    }
}

@Composable
fun LoginScreen() {
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
            LoginBox()
        }
    }
}

