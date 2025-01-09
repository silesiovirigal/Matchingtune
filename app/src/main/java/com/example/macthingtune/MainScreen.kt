package com.example.macthingtune

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(username: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Bem-vindo, $username!") },

            )
        }
    ) { padding ->
        val scrollState = rememberScrollState() // Gerencia o estado do scroll
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(scrollState), // Adiciona o scroll vertical
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Seções da tela
            SectionTitle("Recomendações de Músicas")
            repeat(5) { // Repetindo elementos para simular mais conteúdo
                RecommendationCard(title = "Música ${it + 1}", description = "Artista - Álbum")
            }

            SectionTitle("Artistas que você pode gostar")
            repeat(5) {
                RecommendationCard(title = "Artista ${it + 1}", description = "Gênero Musical")
            }

            SectionTitle("Eventos Próximos")
            repeat(5) {
                RecommendationCard(title = "Evento ${it + 1}", description = "Data e Local")
            }

            SectionTitle("Pessoas com gostos similares")
            repeat(5) {
                RecommendationCard(title = "Perfil ${it + 1}", description = "Gênero Favorito")
            }
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun RecommendationCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(title, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(description, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(username = "Exemplo")
}
