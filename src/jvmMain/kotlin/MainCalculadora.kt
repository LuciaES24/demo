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
import kotlin.math.sqrt

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App7()
    }
}

@Composable
@Preview
fun App7(){
    var numeroActual=""
    var numeroAnterior=""
    var operacion = ""
    var total = 0.0
    var pantalla by remember { mutableStateOf("") }
    MaterialTheme {
        Column (
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            OutlinedTextField(
                value = pantalla,
                onValueChange = { pantalla = it },
                modifier = Modifier
                    .padding(bottom = 16.dp)
            )
            Row {
                Button(onClick = {
                    pantalla="^2"
                    operacion="^2"
                }){
                    Text("^2")
                }
                Button(onClick = {
                    pantalla="^x"
                    operacion="^x"
                    numeroAnterior = numeroActual
                    numeroActual=""
                }){
                    Text("^x")
                }
                Button(onClick = {
                    pantalla="%"
                    operacion="%"
                    numeroAnterior = numeroActual
                    numeroActual=""
                }){
                    Text("%")
                }
                Button(onClick = {
                    pantalla="√"
                    operacion="√"
                    numeroAnterior=numeroActual
                }){
                    Text("√")
                }
            }
            Row {
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
                    operacion="+"
                    numeroAnterior = numeroActual
                    numeroActual=""
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
                    if (numeroActual==""){
                        numeroActual+="-"
                    }else if (numeroAnterior==""){
                        numeroAnterior+=""
                    }else{
                        pantalla="-"
                        operacion="-"
                        numeroAnterior = numeroActual
                        numeroActual=""
                    }
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
                    operacion="x"
                    numeroAnterior = numeroActual
                    numeroActual=""
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
                    numeroAnterior=""
                    operacion=""
                }){
                    Text("C")
                }
                Button(onClick = {
                    numeroActual+="0"
                    pantalla = numeroActual
                }){
                    Text("0")
                }
                Button(onClick = {
                    when(operacion){
                        "/"->total=numeroAnterior.toDouble()/numeroActual.toDouble()
                        "+"->total=numeroAnterior.toDouble()+numeroActual.toDouble()
                        "-"->total=numeroAnterior.toDouble()-numeroActual.toDouble()
                        "x"->total=numeroAnterior.toDouble()*numeroActual.toDouble()
                        "^2"->total=numeroActual.toDouble()*numeroActual.toDouble()
                        "^x"->{
                            val numero = numeroAnterior
                            for (i in 1..numeroActual.toInt()-1){
                                total=numeroAnterior.toDouble()*numero.toDouble()
                                numeroAnterior=total.toString()
                            }
                        }
                        "%"->total=numeroAnterior.toDouble()*numeroActual.toDouble()/100
                        "√"-> {
                            numeroActual = numeroActual + ".00"
                            total= sqrt(numeroAnterior.toDouble())
                        }
                    }
                    pantalla=total.toString()
                    numeroActual=total.toString()
                }){
                    Text("=")
                }
                Button(onClick = {
                    pantalla="/"
                    operacion="/"
                    numeroAnterior = numeroActual
                    numeroActual=""
                }){
                    Text("/")
                }
            }
        }
    }
}