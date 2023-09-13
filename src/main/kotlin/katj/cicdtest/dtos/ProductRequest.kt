package katj.cicdtest.dtos

import katj.cicdtest.entity.Product

data class ProductRequest(
    val name: String,
    val price: Long,
    val qty: Int
)

fun ProductRequest.toEntity() = Product(
    name = name,
    price = price,
    qty = qty
)