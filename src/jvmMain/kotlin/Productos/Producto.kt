package Productos

class Producto(tipo:String, cod:Int, nom:String, price:Double) {
    var tipoProducto = tipo
    var codigo = cod
    var nombre = nom
    var precio = price

    fun imprimir():String{
        return "$tipoProducto $codigo $nombre $precio"
    }
}