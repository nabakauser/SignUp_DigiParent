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
import com.example.signup_dp.ui.theme.signup.screens.DigivalLogo
import com.example.signup_dp.ui.theme.signup.screens.EnterRegisteredEmailOrNumber
import com.example.signup_dp.ui.theme.signup.screens.HelpText
import com.example.signup_dp.ui.theme.signup.screens.SignUpText

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen("",{},"",{},"",{}, false, true,{}, {}, {})
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterName(
    name: String,
    onNameEntered: (String) -> Unit
) {
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
            value = name,
            onValueChange = onNameEntered,
            placeholder = {
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
    text: String,
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
            text = text
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
            placeholder = {
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
fun SignUpButton(
    isEnabled: Boolean,
    onSignUpClicked: ()-> Unit
) {
    OutlinedButton(
        enabled = isEnabled,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = onSignUpClicked,
        shape = RoundedCornerShape(2.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.digi_blue))
    ) {
        Text(
            modifier = Modifier.padding(5.dp),
            style = TextStyle(
                color = colorResource(id = R.color.white),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            text = "Sign Up"
        )
    }
}

@Composable
fun AlreadyUserText() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
    ) {
        Text(text = "Already User?")
        Spacer(modifier = Modifier.padding(2.dp))

    }
}

@Composable
fun LoginButton(
    onLoginButtonClicked : () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        onClick = onLoginButtonClicked,
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
            text = "Log In"
        )
    }
}

@Composable
fun SignUpBox(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
    name: String,
    onNameEntered: (String) -> Unit,
    password: String,
    onPasswordEntered: (String) -> Unit,
    isEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    onHelpClicked: () -> Unit,
    onLoginButtonClicked: () -> Unit
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
        EnterRegisteredEmailOrNumber(
            registeredEmailOrNumber = registeredEmailOrNumber,
            onRegisteredEmailOrNumberEntered = onRegisteredEmailOrNumberEntered
        )
        EnterName(
            name = name,
            onNameEntered = onNameEntered
        )
        SetYourPassword(
            text = "Set Your Password",
            password = password,
            onPasswordEntered = onPasswordEntered
        )
        SignUpButton(
            isEnabled = true,
            onSignUpClicked = onSignUpClicked
        )
        HelpText(
            onHelpClicked = onHelpClicked
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        AlreadyUserText()
        LoginButton(
            onLoginButtonClicked = onLoginButtonClicked
        )
    }
}



@Composable
fun SignUpScreen(
    registeredEmailOrNumber: String,
    onRegisteredEmailOrNumberEntered: (String) -> Unit,
    name: String,
    onNameEntered: (String) -> Unit,
    password: String,
    onPasswordEntered: (String) -> Unit,
    isLoading: Boolean = false,
    isEnabled: Boolean,
    onSignUpClicked: () -> Unit,
    onHelpClicked: () -> Unit,
    onLoginButtonClicked: () -> Unit,
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
            SignUpBox(
                registeredEmailOrNumber = registeredEmailOrNumber,
                onRegisteredEmailOrNumberEntered = onRegisteredEmailOrNumberEntered,
                name = name,
                onNameEntered = onNameEntered,
                password = password,
                onPasswordEntered = onPasswordEntered,
                isEnabled = isEnabled,
                onSignUpClicked = onSignUpClicked,
                onHelpClicked = onHelpClicked,
                onLoginButtonClicked = onLoginButtonClicked
            )
        }
    }
}