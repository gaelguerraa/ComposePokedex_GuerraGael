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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gael.guerra.composepokedex.ui.theme.Fire

@Composable
fun LoginScreen(
    onLogin: (username: String, password: String) -> Boolean,
    onLoginSuccess: () -> Unit,
    onGoToRegister: () -> Unit,
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "Iniciar sesión",
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

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (username.isBlank() || password.isBlank()) {
                    errorMessage = "Usuario y contraseña son obligatorios"
                    return@Button
                }

                val success = onLogin(username.trim(), password)
                if (success) {
                    onLoginSuccess()
                } else {
                    errorMessage = "Credenciales inválidas"
                }
            },
            modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Fire)
        ) {
            Text("Entrar")
        }

        TextButton(onClick = onGoToRegister) {
            Text("Crear cuenta",color = Fire.copy(alpha = 0.7f))
        }

        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = errorMessage!!)
        }
    }
}

@Preview(showBackground = true, name = "Login Preview", showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    // Aquí envolvemos el LoginScreen con el tema de tu app si tienes uno
    // MaterialTheme {
    LoginScreen(
        onLogin = { user, pass ->
            // Simulamos que el login es exitoso si no están vacíos
            user.isNotEmpty() && pass.isNotEmpty()
        },
        onLoginSuccess = { /* No hace nada en el preview */ },
        onGoToRegister = { /* No hace nada en el preview */ }
    )
    // }
}