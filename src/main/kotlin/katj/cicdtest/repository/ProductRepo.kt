package katj.cicdtest.repository

import katj.cicdtest.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepo : JpaRepository<Product, Long?> {
    fun findByName(name: String): Product?
}