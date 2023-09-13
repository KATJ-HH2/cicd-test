package katj.cicdtest.entity

import jakarta.persistence.*

@Entity
@Table(name = "PRODUCT")
class Product(
    val name: String,
    val price: Long,
    val qty: Int
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}