package Productos

abstract class Produt {
    var regularPrice:Double

    constructor(regularInitialPrice:Double){
        regularPrice=regularInitialPrice
    }

    abstract fun computeSalePrice():Double

    abstract fun showProduct()

    abstract fun computeSpecialCustomerPrice():Double
}
