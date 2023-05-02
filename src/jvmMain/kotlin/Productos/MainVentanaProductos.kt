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
            DropdownMenu(
                expanded = true,
                onDismissRequest = {},
                offset = DpOffset(50.dp,250.dp),
                modifier = Modifier.width(192.dp)
            ){
                tipos.forEach{
                    DropdownMenuItem(onClick = {
                        
                }){

                    } }
            }
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