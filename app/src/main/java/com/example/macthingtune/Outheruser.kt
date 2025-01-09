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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtherUserProfileScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Perfil de Outro Usuário") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Avatar do Outro Usuário
            val avatarPainter = painterResource(android.R.drawable.ic_menu_gallery) // Substitua pelo recurso real
            Image(
                painter = avatarPainter,
                contentDescription = "Foto do Perfil do Outro Usuário",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Nome do Outro Usuário
            Text(
                text = "Nome do Usuário",
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Bio do Outro Usuário
            Text(
                text = "Sou um fã de música Pop e adoro explorar novos artistas.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Número de Seguidores e Seguindo
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Seguidores: ",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "2,345",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.width(32.dp))

                Text(
                    text = "Seguindo: ",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "987",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Gostos Musicais
            Text(
                text = "Gostos Musicais:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pop, Rock, R&B",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botão de Conectar
            Button(
                onClick = { /* Ação de conectar ou seguir */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text("Conectar")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botões de Redes Sociais
            Text(
                text = "Interagir via Redes Sociais:",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Botão do Instagram
                SocialButton(icon = painterResource(id = R.drawable.ic_launcher_background), link = "https://www.instagram.com/usuario")

                Spacer(modifier = Modifier.width(16.dp))

                // Botão do Twitter
                SocialButton(icon = painterResource(id = R.drawable.ic_launcher_foreground), link = "https://www.twitter.com/usuario")


                // Botão do WhatsApp

            }
        }
    }
}

@Composable
fun SocialButton(icon: Painter, link: String) {
    IconButton(
        onClick = {
            // Aqui você pode adicionar a ação de abrir o link na rede social, por exemplo:
            // val context = LocalContext.current
            // val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            // context.startActivity(intent)
        },
        modifier = Modifier.size(48.dp)
    ) {
        Icon(painter = icon, contentDescription = null, modifier = Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun OtherUserProfileScreenPreview() {
    OtherUserProfileScreen()
}
