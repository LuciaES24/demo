package Productos

abstract class Electronics : Produt {
    var manufacturer = ""

    constructor(regularInitialPrice:Double, manufact:String):super(regularInitialPrice){
        regularPrice = regularInitialPrice
        manufacturer = manufact
    }

    override fun showProduct() {}

}