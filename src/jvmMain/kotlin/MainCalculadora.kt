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
        App7()
    }
}

@Composable
@Preview
fun App7(){
    var text by remember { mutableStateOf("") }
    var numeroActual=""
    var numeroNuevo=""
    var operacion = ""
    var total = 0
    var pantalla by remember { mutableStateOf("") }
    MaterialTheme {
        Column (
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            OutlinedTextField(
                value = pantalla,
                onValueChange = { pantalla = it },
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Row (
            ){
                Button(onClick = {
                    numeroActual+="1"
                    pantalla = numeroActual
                }){
                    Text("1")
                }
                Button(onClick = {
                    numeroActual+="2"
                    pantalla = numeroActual
                }){
                    Text("2")
                }
                Button(onClick = {
                    numeroActual+="3"
                    pantalla = numeroActual
                }){
                    Text("3")
                }
                Button(onClick = {
                    pantalla="+"
                    operacion=numeroActual+"+"
                }){
                    Text("+")
                }
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = {
                    numeroActual+="4"
                    pantalla = numeroActual
                }){
                    Text("4")
                }
                Button(onClick = {
                    numeroActual+="5"
                    pantalla = numeroActual
                }){
                    Text("5")
                }
                Button(onClick = {
                    numeroActual+="6"
                    pantalla = numeroActual
                }){
                    Text("6")
                }
                Button(onClick = {
                    pantalla="-"
                }){
                    Text("-")
                }
            }
            Row (
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = {
                    numeroActual+="7"
                    pantalla = numeroActual
                }){
                    Text("7")
                }
                Button(onClick = {
                    numeroActual+="8"
                    pantalla = numeroActual
                }){
                    Text("8")
                }
                Button(onClick = {
                    numeroActual+="9"
                    pantalla = numeroActual
                }){
                    Text("9")
                }
                Button(onClick = {
                    pantalla="x"
                }){
                    Text("x")
                }
            }
            Row (
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ){
                Button(onClick = {
                    pantalla=""
                    numeroActual=""
                    numeroNuevo=""
                    operacion=""
                }){
                    Text("DEL")
                }
                Button(onClick = {
                    numeroActual+="0"
                    pantalla = numeroActual
                }){
                    Text("0")
                }
                Button(onClick = {
                    pantalla=operacion.toString()
                }){
                    Text("=")
                }
                Button(onClick = {
                    pantalla="/"
                }){
                    Text("/")
                }
            }
        }
    }
}