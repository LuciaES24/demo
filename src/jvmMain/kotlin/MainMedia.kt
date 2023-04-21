import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


import androidx.compose.foundation.layout.*
import androidx.compose.material.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun main()  = application {
    Window(onCloseRequest = ::exitApplication) {
        App2()
    }
}

@Composable
@Preview
fun App2() {
    var text by remember { mutableStateOf("Vamos a calcular la media de 2 números") }

    MaterialTheme {
        var numero1 by remember { mutableStateOf("") }
        var numero2 by remember { mutableStateOf("") }
        var mediaFinal by remember { mutableStateOf("") }

        MaterialTheme {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Calcular la media", modifier = Modifier.padding(bottom = 16.dp))
                OutlinedTextField(
                    value = numero1,
                    onValueChange = { numero1 = it },
                    label = { Text("Numero 1") },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                OutlinedTextField(
                    value = numero2,
                    onValueChange = { numero2 = it },
                    label = { Text("Numero 2") },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick = { mediaFinal = media(numero1.toInt(), numero2.toInt()) }) {
                    Text("Calcular")
                }
                if (mediaFinal.isNotBlank()) {
                    Text(
                        "La media es $mediaFinal",
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }
    }
}

fun media(uno: Int, dos: Int): String {
    return ((uno+dos)/2).toString()
}
