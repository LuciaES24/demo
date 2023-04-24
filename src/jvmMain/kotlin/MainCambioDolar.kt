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
        App4()
    }
}

@Composable
@Preview
fun App4() {
    var text by remember { mutableStateOf("Vamos a hacer el cambio de euros a dolares") }

    MaterialTheme {
        var moneda by remember { mutableStateOf("") }
        var cambioFinal by remember { mutableStateOf("") }

        MaterialTheme {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Cambio de euros a dólares", modifier = Modifier.padding(bottom = 16.dp))
                OutlinedTextField(
                    value = moneda,
                    onValueChange = { moneda = it },
                    label = { Text("Euros") },
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick =  {
                    cambioFinal=(moneda.toInt()*1.10).toString()
                    moneda=""
                }){
                    Text("Calcular")
                }

                Text(
                    "Son $cambioFinal dólares",
                    modifier = Modifier.padding(top = 16.dp)
                )

            }
        }
    }
}