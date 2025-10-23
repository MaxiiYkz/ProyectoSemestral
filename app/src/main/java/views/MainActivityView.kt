package com.example.netgames.views // Carpeta conceptual

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netgames.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    // Usamos Box para superponer el fondo y el contenido
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.videojuegos_bg),
            contentDescription = "Fondo de control",
            modifier = Modifier.fillMaxSize().alpha(0.2f),
            contentScale = ContentScale.Crop
        )

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("NetGames") }
                )
            },
            containerColor = androidx.compose.ui.graphics.Color.Transparent
        ) { paddingValues ->
            // LazyColumn es como un RecyclerView para mostrar listas de forma eficiente
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
            ) {
                item {
                    Text(
                        text = "Categorías Populares",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                // Aquí iría la lógica para mostrar la lista de categorías
                items(3) { index ->
                    CategoryCard() // Tarjeta de categoría de ejemplo
                }

                item {
                    Text(
                        text = "Reseñas de Clientes",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                // Aquí iría la lógica para la lista de reseñas
                items(3) { index ->
                    ReviewCard() // Tarjeta de reseña de ejemplo
                }
            }
        }
    }
}

// Ejemplo de cómo se vería una tarjeta (puedes personalizarlas)
@Composable
fun CategoryCard() {
    Card(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
        Text("Ejemplo de Categoría", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun ReviewCard() {
    Card(modifier = Modifier.padding(vertical = 8.dp).fillMaxWidth()) {
        Text("Ejemplo de Reseña", modifier = Modifier.padding(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MainView()
}
