package com.example.macthingtune

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
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
fun EventsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Eventos Musicais") },

            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Título para a seção de eventos
            Text(
                text = "Eventos Recomendados",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )

            // Lista de eventos
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(eventsList) { event ->
                    EventItem(event)
                }
            }
        }
    }
}

@Composable
fun EventItem(event: Event) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        //elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Nome do Evento
            Text(
                text = event.name,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Data e Hora do Evento
            Text(
                text = "Data: ${event.date} - Hora: ${event.time}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Localização do Evento
            Text(
                text = "Local: ${event.location}",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botão de Detalhes do Evento
            Button(
                onClick = { /* Ação para ver detalhes do evento */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver Detalhes")
            }
        }
    }
}

data class Event(
    val name: String,
    val date: String,
    val time: String,
    val location: String
)

// Lista de eventos de exemplo
val eventsList = listOf(
    Event("Show de Rock", "20/01/2025", "20:00", "Lisboa Arena"),
    Event("Festival de Música Eletrônica", "22/01/2025", "18:00", "Porto Convention Center"),
    Event("Concerto de Jazz", "25/01/2025", "21:00", "Cascais Theater")
)


@Preview(showBackground = true)
@Composable
fun EventsScreenPreview() {
    EventsScreen()
}
