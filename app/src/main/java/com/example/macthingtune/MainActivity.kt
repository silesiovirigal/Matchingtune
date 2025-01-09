package com.example.macthingtune

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginScreen(
                onLoginClick = { initiateSpotifyLogin() } // Chama a função de login
            )
            /*MacthingTuneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }


            }*/

        }
    }
    private fun initiateSpotifyLogin() {
        val clientId = "049293a9f9054a2facddd1d2e140a651"  // Substitua pelo seu Client ID
        val redirectUri = "com.matchingtune://spotify_auth"
        val scopes = "user-read-private user-read-email user-top-read"

        // URL de autenticação
        val authUrl = "https://accounts.spotify.com/authorize" +
                "?client_id=$clientId" +
                "&response_type=code" +
                "&redirect_uri=$redirectUri" +
                "&scope=$scopes"

        // Abrir no navegador
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(authUrl))
        startActivity(intent)
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)

        intent?.data?.let { uri ->
            if (uri.toString().startsWith("com.matchingtune://spotify_auth")) {
                val code = uri.getQueryParameter("code") // Captura o código
                if (code != null) {
                    Log.d("SpotifyAuth", "Authorization Code: $code")
                    exchangeCodeForToken(code) // Troca o código pelo token
                } else {
                    val error = uri.getQueryParameter("error")
                    Log.e("SpotifyAuth", "Error: $error")
                }
            }
        }
    }

    private fun exchangeCodeForToken(code: String) {

    }


}

@Composable
fun LoginScreen(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Text("MatchingTune", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(32.dp))

        // Botões de plataformas
        Button(
            onClick = { onLoginClick()},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar com Spotify")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Login com YouTube Music */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar com YouTube Music")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Campos de e-mail e senha (opcional)
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { /* TODO: Login Manual */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Link para Esqueci minha senha
        TextButton(onClick = { /* TODO: Recuperar senha */ }) {
            Text("Esqueci minha senha")
        }
    }
}

fun onLoginClick() {
}

/*@Preview(showBackground = true) // Mostra o fundo no preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginClick)
}*/
/*
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MacthingTuneTheme {
        Greeting("Android")
    }
}*/
