package Productos

class TV : Electronics {
    var size = 0
    constructor(regularInitialPrice:Double, manufact:String, s:Int):super(regularInitialPrice, manufact){
        regularPrice = regularInitialPrice
        manufacturer = manufact
        size = s
    }

    override fun computeSalePrice(): Double {
        return regularPrice*0.8
    }

    override fun computeSpecialCustomerPrice(): Double {
        return this.computeSalePrice() - 100
    }

    override fun showProduct() {
        println("TV\nRegular Price: $regularPrice\nManufacturer: $manufacturer\nSize: $size\nFinal Price: ${this.computeSpecialCustomerPrice()}")

    }
}