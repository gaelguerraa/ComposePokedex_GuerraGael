package gael.guerra.composepokedex.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gael.guerra.composepokedex.ui.theme.Fire

@Composable
fun RegisterScreen(
    onRegister: (username: String, password: String, repeatPassword: String) -> String?,
    onRegisterSuccess: () -> Unit,
    onBackToLogin: () -> Unit,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repeatPassword by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Registro",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it; errorMessage = null },
            label = { Text("Usuario") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it; errorMessage = null },
            label = { Text("Contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = repeatPassword,
            onValueChange = { repeatPassword = it; errorMessage = null },
            label = { Text("Repetir contraseña") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val error = onRegister(username.trim(), password, repeatPassword)
                if (error == null) {
                    onRegisterSuccess()
                } else {
                    errorMessage = error
                }
            },
            modifier = Modifier.fillMaxWidth(),colors = ButtonDefaults.buttonColors(containerColor = Fire)
        ) {
            Text("Registrarme")
        }

        TextButton(onClick = onBackToLogin) {
            Text("Ya tengo cuenta", color = Fire.copy(alpha = 0.7f))
        }

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage!!)
        }
    }
}

@Preview(showBackground = true, name = "Register Preview", showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    // Si tienes un Theme definido (ej. AppTheme), envuélvelo aquí
    RegisterScreen(
        onRegister = { user, pass, repeat ->
            // Simulación: Si las contraseñas no coinciden, devuelve un error
            if (pass != repeat) "Las contraseñas no coinciden" else null
        },
        onRegisterSuccess = { /* Acción al registrarse con éxito */ },
        onBackToLogin = { /* Acción para volver */ }
    )
}