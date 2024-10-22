package com.diego.instagramcompose

import android.app.Activity
import android.util.Patterns
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(colorResource(id = R.color.white))
    ) {
        Header(modifier = modifier.align(Alignment.TopEnd))
        Body(modifier = modifier.align(Alignment.Center))
        Footer(modifier = modifier.align(Alignment.BottomCenter))
    }

}

@Composable
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        HorizontalDivider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SingUp()
        Spacer(modifier = Modifier.size(24.dp))
    }
}

@Composable
fun SingUp() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(text = "Don't have an account?", fontSize = 12.sp, color = Color(0xFFB5B5B5))
        Text(
            text = "Sing up.",
            Modifier.padding(horizontal = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable {
        mutableStateOf("")
    }
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isLoginEnable by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier
    ) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        Email(email = email, Modifier.fillMaxWidth()) {
            email = it
            isLoginEnable = enableLogin(email,password)
        }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password = password, Modifier.fillMaxWidth()) {
            password = it
            isLoginEnable = enableLogin(email,password)
        }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(enable = isLoginEnable)
        Spacer(modifier = Modifier.size(16.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(32.dp))
        SocialLogin()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Email(email: String, modifier: Modifier, onInput: (String) -> Unit) {
    TextField(
        modifier = modifier,
        value = email,
        onValueChange = {
            onInput(it)
        },
        placeholder = {
            Text("Phone number, user name or email") // Usar un Composable Text para el placeholder
        },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFFB2B2B2),
            unfocusedTextColor = Color(0xFFB2B2B2),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}


@Composable
fun Password(password: String, modifier: Modifier, onInput: (String) -> Unit) {
    var passwordVisibility by rememberSaveable {
        mutableStateOf(false)
    }
    TextField(
        modifier = modifier,
        value = password,
        onValueChange = {
            onInput(it)
        },
        placeholder = {
            Text(text = "Pasword")
        },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color(0xFFB2B2B2),
            unfocusedTextColor = Color(0xFFB2B2B2),
            unfocusedContainerColor = Color(0xFFFAFAFA),
            focusedContainerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val imagen = if (passwordVisibility) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(imageVector = imagen, contentDescription = "Show password")
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9),
        modifier = modifier
    )
}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Logo instagram",
        modifier = modifier
    )
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close app",
        modifier = modifier.clickable {
            activity.finish()
        })
}

@Composable
fun LoginButton(enable: Boolean) {
    Button(
        onClick = { /*TODO*/ },
        enabled = enable,
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4EA8E9),
            disabledContainerColor = Color(0xFF78c8f9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
        Text(text = "Log in")
    }

}

@Composable
fun LoginDivider() {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        HorizontalDivider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 15.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        HorizontalDivider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social Login",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = "Continue Diego Perez",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color(0xFF4EA8E9)
        )
    }
}


fun enableLogin(email: String,password: String):Boolean{
    return Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
    password.length > 6
}