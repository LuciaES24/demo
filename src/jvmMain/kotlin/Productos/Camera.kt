package Productos

class Camera: Electronics {

    constructor(regularInitialPrice:Double, manufact:String):super(regularInitialPrice, manufact){
        regularPrice = regularInitialPrice
        manufacturer = manufact
    }

    override fun computeSalePrice(): Double {
        return regularPrice*0.7
    }

    override fun computeSpecialCustomerPrice(): Double {
        return this.computeSalePrice() - 205
    }

    override fun showProduct() {
        println("Camera\nRegular Price: $regularPrice\nManufacturer: $manufacturer\nFinal Price: ${this.computeSpecialCustomerPrice()}")
    }
}