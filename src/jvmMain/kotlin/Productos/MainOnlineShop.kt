package Productos

fun main(){
    var compra = mutableListOf<Produt>()

    var television = TV(1000.00,"Samsung",30)
    compra.add(television)
    var television2 = TV(2000.00,"Sony",50)
    compra.add(television2)
    var mp3 = MP3Player(250.50,"Apple","blue")
    compra.add(mp3)
    var book1 = Book(34.89,"Sun press",1992)
    compra.add(book1)
    var book2 = Book(15.75,"Korea press",1986)
    compra.add(book2)
    var camera1 = Camera(789.80,"Canon")
    compra.add(camera1)
    var camera2 = Camera(657.99,"Nikon")
    compra.add(camera2)

    var totalRegularPrice = 0.0
    var totalSpecialSalePrice = 0.0
    var totalSalePrice = 0.0

    for (i in compra){
        i.showProduct()
        println()
        totalRegularPrice += i.regularPrice
        totalSpecialSalePrice += i.computeSpecialCustomerPrice()
        totalSalePrice += i.computeSalePrice()
    }

    println("Total Regular Price: $totalRegularPrice")
    println()
    println("Total Final Special Price: $totalSpecialSalePrice")
    println()
    println("Total Final Price: $totalSalePrice")
}