// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
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

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var contador = 0

    MaterialTheme {
        Button(onClick = {
            contador++
            //imprime un mensaje distinto cada vez que pulsa el botón
            if (contador%2!=0){
                text="aprobaste programación"
            }else{
                text="Mentira"
            }
            //text = contador.toString()
            //text = aleatorio().toString()
        }) {
            Text(text)
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}

//imprime un numero aleatorio cada vez que pulsas el botón
fun aleatorio():Int{
    return (0..10).random()
}