package com.ecfcode.springstore.infrastructure.entities.concretes;

import com.ecfcode.springstore.domain.models.ProductDO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "units_on_order")
    private int unitsOnOrder;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name = "discontinued")
    private int discontinued;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @ManyToOne
    @JoinColumn(name = "category_id",
            nullable = false,
            referencedColumnName = "category_id",
            foreignKey = @ForeignKey(
                    name = "category_id_fk"
            ))
    private Category category;


    @ManyToOne
    @JoinColumn(name = "supplier_id",
            nullable = false,
            referencedColumnName = "supplier_id",
            foreignKey = @ForeignKey(
                    name = "supplier_id_fk"
            ))
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;

    public Product(final ProductDO product) {
        this.productId = product.getProductId();
        this.unitPrice = product.getUnitPrice();

        this.productName = product.getProductName();
        this.unitsInStock = product.getUnitsInStock();
        this.discontinued = product.getDiscontinued();
        this.quantityPerUnit = product.getQuantityPerUnit();
        this.unitsOnOrder = product.getUnitsOnOrder();
    }

    public ProductDO toProductDO() {
        return new ProductDO(
                this.productId,
                this.productName,
                this.supplier.getSupplierId(),
                this.category.getCategoryId(),
                this.quantityPerUnit,
                this.unitPrice,
                this.unitsInStock,
                this.unitsOnOrder,
                this.reorderLevel,
                this.discontinued
        );

    }
}
