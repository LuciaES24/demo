package Productos

class Book : Produt {
    var publisher = ""
    var yearPublished = 0
    constructor(regularInitialPrice:Double, publi : String, year:Int):super(regularInitialPrice){
        regularPrice = regularInitialPrice
        publisher = publi
        yearPublished = year
    }

    override fun computeSalePrice(): Double {
        return regularPrice*0.5
    }

    override fun computeSpecialCustomerPrice(): Double {
        return this.computeSalePrice() - 2
    }

    override fun showProduct() {
        println("Book\nRegular Price: $regularPrice\nPublisher: $publisher\nYear Published: $yearPublished\nFinal Price: ${this.computeSpecialCustomerPrice()}")

    }
}