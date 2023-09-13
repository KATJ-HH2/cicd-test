package katj.cicdtest.service

import jakarta.transaction.Transactional
import katj.cicdtest.dtos.ProductRequest
import katj.cicdtest.dtos.toEntity
import katj.cicdtest.dtos.ProductResponse
import katj.cicdtest.dtos.toResponse
import katj.cicdtest.repository.ProductRepo
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepo: ProductRepo
) {
    @Transactional
    fun insertProduct(productReq: ProductRequest) {
        productRepo.save(productReq.toEntity())
    }

    fun getProduct(id: Long): ProductResponse {
        val product = productRepo.findByIdOrNull(id) ?: throw IllegalStateException("상품이 없습니다.")

        return product.toResponse()
    }
}