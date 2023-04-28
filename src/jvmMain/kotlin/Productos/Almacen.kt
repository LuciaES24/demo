package Productos

import androidx.compose.material.Text

class Almacen {
    var listaAlmacen = mutableListOf<Producto>()

    fun anadir(p:Producto){
        listaAlmacen.add(p)
    }

    fun mostrarAlmacen():String{
        var todos = ""
        for (producto in listaAlmacen){
            todos += producto.imprimir()+"|"
        }
        return todos
    }
}