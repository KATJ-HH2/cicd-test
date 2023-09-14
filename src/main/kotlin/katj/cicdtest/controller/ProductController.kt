package katj.cicdtest.controller

import katj.cicdtest.dtos.ProductRequest
import katj.cicdtest.dtos.ProductResponse
import katj.cicdtest.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
) {
    @PostMapping()
    fun addProduct1(@RequestBody productRequest: ProductRequest) {
        productService.insertProduct(productRequest)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable("id") id: Long): ProductResponse {
        return productService.getProduct(id)
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "hello world!!"
    }

}