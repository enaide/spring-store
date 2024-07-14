package com.ecfcode.springstore.domain.concretes;

import com.ecfcode.springstore.core.utilities.mapping.ModelMapperService;
import com.ecfcode.springstore.core.utilities.results.DataResult;
import com.ecfcode.springstore.core.utilities.results.Result;
import com.ecfcode.springstore.core.utilities.results.SuccessDataResult;
import com.ecfcode.springstore.core.utilities.results.SuccessResult;
import com.ecfcode.springstore.domain.abstracts.CartProductService;
import com.ecfcode.springstore.domain.requests.cartproducts.CreateCartProductRequest;
import com.ecfcode.springstore.domain.requests.cartproducts.DeleteCartProductRequest;
import com.ecfcode.springstore.domain.requests.cartproducts.UpdateCartProductRequest;
import com.ecfcode.springstore.domain.responses.cartProducts.CartProductListResponse;
import com.ecfcode.springstore.infrastructure.abstracts.CartProductRepository;
import com.ecfcode.springstore.infrastructure.abstracts.ProductRepository;
import com.ecfcode.springstore.infrastructure.entities.concretes.CartProduct;
import com.ecfcode.springstore.infrastructure.entities.concretes.Product;
import com.ecfcode.springstore.infrastructure.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartProductManager implements CartProductService{

	CartProductRepository cartProductRepository;
    ModelMapperService modelMapperService;
    ProductRepository productRepository;

    @Autowired
    public CartProductManager(CartProductRepository cartProductRepository, 
    		ModelMapperService modelMapperService,ProductRepository productRepository) {
        this.cartProductRepository = cartProductRepository;
        this.modelMapperService = modelMapperService;
        this.productRepository = productRepository;
    }

    @Override
    public Result add(CreateCartProductRequest createCartProductRequest) {
        var id = createCartProductRequest.getProductId();
        CartProduct cartProduct = this.modelMapperService.forRequest().map(createCartProductRequest, CartProduct.class);
        Product product = this.productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product with given id: "+ id +" doesn't exist"));
        cartProduct.setUnitPrice(product.getUnitPrice());
        this.cartProductRepository.save(cartProduct);
        return  new SuccessResult();
    }

    @Override
    public Result update(UpdateCartProductRequest updateCartProductRequest) {
        CartProduct cartProduct = this.modelMapperService.forRequest().map(updateCartProductRequest, CartProduct.class);
        this.cartProductRepository.save(cartProduct);
        return new SuccessResult();
    }

    @Override
    public Result delete(DeleteCartProductRequest deleteCartProductRequest) {
        this.cartProductRepository.deleteById(deleteCartProductRequest.getCartProductId());
        return new SuccessResult();
    }

    @Override
    public DataResult<List<CartProductListResponse>> getAll() {
        List<CartProduct> result = this.cartProductRepository.findAll();
        List<CartProductListResponse> responses = result.stream().map(cartProduct -> this.modelMapperService.forResponse()
                .map(cartProduct,CartProductListResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<CartProductListResponse>>(responses);
    }

    @Override
    public DataResult<CartProductListResponse> getById(int cartProductId) {
    	CartProduct cartProduct = this.cartProductRepository.findById(cartProductId).get();
    	CartProductListResponse response = this.modelMapperService.forRequest().map(cartProduct, CartProductListResponse.class);
		return new SuccessDataResult<CartProductListResponse>(response);
    }

}
