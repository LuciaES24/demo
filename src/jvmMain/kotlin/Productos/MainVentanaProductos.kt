package Productos

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
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
    val tipos = listOf("TV", "MP3Player", "Camera", "Book")
    var tipoP by remember { mutableStateOf("") }
    var prec by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var publisher by remember { mutableStateOf("") }
    var anio by remember { mutableStateOf("") }
    var situacion by remember { mutableStateOf("true") }
    val almacen = Almacen()


    MaterialTheme {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            DropdownMenu(
                expanded = true,
                onDismissRequest = {},
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ){
                tipos.forEach{tipoP->
                    DropdownMenuItem( onClick = {
                        if (tipoP == "TV"){
                            Column {
                                TextField(
                                    value = prec,
                                    onValueChange = {prec=it},
                                )
                                TextField(
                                    value = name,
                                    onValueChange = {name=it}
                                )
                                TextField(
                                    value = size,
                                    onValueChange = {size=it}
                                )
                            }
                        }else if(tipoP=="Camera"){
                            Column {
                                TextField(
                                    value = prec,
                                    onValueChange = { prec = it },
                                )
                                TextField(
                                    value = name,
                                    onValueChange = { name = it }
                                )
                            }
                        }else if(tipoP=="MP3Player"){
                            Column {
                                TextField(
                                    value = prec,
                                    onValueChange = { prec = it },
                                )
                                TextField(
                                    value = name,
                                    onValueChange = { name = it }
                                )
                                TextField(
                                    value = color,
                                    onValueChange = { color = it }
                                )
                            }
                        }
                        else if(tipoP=="Book"){
                            Column {
                                TextField(
                                    value = prec,
                                    onValueChange = { prec = it },
                                )
                                TextField(
                                    value = publisher,
                                    onValueChange = { publisher = it }
                                )
                                TextField(
                                    value = anio,
                                    onValueChange = { anio = it }
                                )
                            }
                        }
                    }){
                        Text(text = tipoP)
                    } }
            }
            Row {
                Button(onClick = {
                    val producto = Producto(tipoP,size.toInt(),name,prec.toDouble())
                    almacen.anadir(producto)
                    tipoP=""
                    size=""
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
                        size=producto.codigo.toString()
                    }
                }){
                    Text("Mostrar")
                }
            }
            Text("${almacen.mostrarAlmacen()}")
        }
    }
}