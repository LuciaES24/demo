package Productos

import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
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
        App8()
    }
}

@Composable
@Preview
fun App8(){
    var tipoP by remember { mutableStateOf("") }
    var prec by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var situacion by remember { mutableStateOf("true") }
    val almacen = Almacen()
    var tipoMostrar by remember { mutableStateOf("") }
    var precioMostrar by remember { mutableStateOf("") }
    var codeMostrar by remember { mutableStateOf("") }
    var nameMostrar by remember { mutableStateOf("") }

    MaterialTheme {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text("Producto")
            Text("Tipo del producto")
            OutlinedTextField(
                value = tipoP,
                onValueChange = {tipoP= it},
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text("Código del producto")
            OutlinedTextField(
                value = code,
                onValueChange = {code=it},
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text("Nombre del producto")
            OutlinedTextField(
                value = name,
                onValueChange = {name=it},
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Text("Precio del producto")
            OutlinedTextField(
                value = prec,
                onValueChange = {prec=it},
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Row {
                Button(onClick = {
                    val producto = Producto(tipoP,code.toInt(),name,prec.toDouble())
                    almacen.anadir(producto)
                    tipoP=""
                    code=""
                    name=""
                    prec=""
                }){
                    Text("Insertar")
                }
                Button(onClick = {
                    for (producto in almacen.listaAlmacen){
                        tipoP=producto.tipoProducto
                        prec=producto.precio.toString()
                        name=producto.nombre
                        code=producto.codigo.toString()
                    }
                }){
                    Text("Mostrar")
                }
            }
            Text("${almacen.mostrarAlmacen()}")
        }
    }
}