import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App6()
    }
}

@Composable
@Preview
fun App6() {
    var text by remember { mutableStateOf("") }

    MaterialTheme {
        var numero by remember { mutableStateOf("") }
        var dinero by remember { mutableStateOf("") }
        MaterialTheme {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Ruleta", modifier = Modifier.padding(bottom = 16.dp))
                OutlinedTextField(
                    value = numero,
                    onValueChange = { numero = it },
                    label = { Text("Número para apostar") },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                OutlinedTextField(
                    value = dinero,
                    onValueChange = { dinero = it },
                    label = { Text("Recargar tarjeta") },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick = {
                    text = aleatorio().toString()
                    if (numero == text) {
                        dinero = (dinero.toInt() + dinero.toInt() * 3).toString()
                    }else {
                        dinero = (dinero.toInt() - 15).toString()
                    }
                }) {
                    Text("Tirar")
                }
                Text(
                    "Ha salido el $text\nActualmente tiene $dinero euros"
                )
            }
        }
    }
}

