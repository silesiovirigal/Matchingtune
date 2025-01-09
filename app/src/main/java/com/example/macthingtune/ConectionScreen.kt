package com.example.macthingtune

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConnectionScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Conexões Recomendadas") },

            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Exemplo de conexões recomendadas
            repeat(5) { index ->
                ConnectionCard(
                    name = "Usuário ${index + 1}",
                    description = "Música Favorita: Música ${index + 1}",
                    avatar = painterResource(android.R.drawable.ic_menu_gallery), // Substitua pelo recurso real
                    onConnect = { /* Ação ao clicar em conectar */ }
                )
            }
        }
    }
}

@Composable
fun ConnectionCard(
    name: String,
    description: String,
    avatar: Painter,
    onConnect: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(120.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Avatar do usuário
            Image(
                painter = avatar,
                contentDescription = "Avatar de $name",
                modifier = Modifier
                    .size(80.dp)
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Informações do usuário
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Botão de Conectar
            Button(
                onClick = onConnect,
                modifier = Modifier
                    .padding(end = 16.dp)
            ) {
                Text("Conectar")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ConnectionScreenPreview() {
    ConnectionScreen()
}
