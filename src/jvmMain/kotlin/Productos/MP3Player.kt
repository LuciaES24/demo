package Productos

class MP3Player: Electronics {
    var color = ""
    constructor(regularInitialPrice:Double, manufact:String, c:String):super(regularInitialPrice, manufact){
        regularPrice = regularInitialPrice
        manufacturer = manufact
        color = c
    }

    override fun computeSalePrice(): Double {
        return regularPrice*0.9
    }

    override fun computeSpecialCustomerPrice(): Double {
        return this.computeSalePrice() - 15
    }

    override fun showProduct() {
        println("MP3Player\nRegular Price: $regularPrice\nManufacturer: $manufacturer\nFinal Price: ${this.computeSpecialCustomerPrice()}")
    }
}