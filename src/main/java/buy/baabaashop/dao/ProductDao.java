package buy.baabaashop.dao;

import buy.baabaashop.common.PaginationRequestParam;
import buy.baabaashop.entity.*;
import buy.baabaashop.entity.cms.CmsProductCategoryParam;
import buy.baabaashop.entity.cms.ProductAttributeRequestParam;
import buy.baabaashop.entity.cms.ProductCategoryWithChildrenItem;
import buy.baabaashop.entity.cms.ProductParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {

    List<Product> selectProductList(PaginationRequestParam param);
    Product selectProductCode(@Param("productId") Integer productId);
    List<ProductSku> selectSkuDetails(@Param("productId") Integer productId);
    List<ProductCategory> selectProductCategoryList(CmsProductCategoryParam param);
    List<ProductAttribute> selectProductAttributeCategory(PaginationRequestParam param);
    List<ProductAttribute> selectProductAttribute(ProductAttributeRequestParam param);
    List<ProductAttribute> selectProductAttributeByCategoryId(ProductAttribute productAttribute);
    Integer selectProductTotalRecord();
    Integer selectProductCategoryTotalRecord();
    ProductCategory selectProductCategoryById(ProductCategory productCategory);
    Integer selectProductAttributeCategoryTotalRecord();
    Integer selectProductAttributeTotalRecord(ProductAttributeRequestParam param);
    ProductAttribute selectProductAttributeById(ProductAttribute productAttribute);
    ProductAttribute selectProductAttributeCategoryById(@Param("id") Integer categoryId);

    void updateProductCategory(ProductCategory productCategory);
    void updateProductAttributeCategory(ProductAttribute productAttribute);
    void updateProductAttribute(ProductAttribute productAttribute);
    void addProductCategory(ProductCategory productCategory);
    void addProductAttributeCategory(ProductAttribute productAttribute);
    void addProductAttribute(ProductAttribute productAttribute);
    void addProduct(ProductParam productParam);
    void updateProduct(ProductParam productParam);
    void addProductSku(@Param("productId") Integer productId, @Param("skuList") List<ProductSku> skuList);
    void addAttributeValue(@Param("productId") Integer productId, @Param("list") List<ProductAttribute> productAttributes);
    void updateAttributeValue(ProductAttribute productAttribute);

    //根据ID查找商品详情
    ProductParam selectProductDetail(@Param("id") Integer id);

    //删除商品分类
    void deleteProductCategory(@Param("id") Integer categoryId);

    //删除商品分类的同时删除子分类
    void deleteProductSubcategory(@Param("id") Integer categoryId);

    //删除商品
    void deleteProduct(@Param("id") Integer productId);

    //删除商品的同时删除添加商品时手动添加的商品属性
    void deleteProductAttributeValue(@Param("id") Integer productId);

    //删除商品也要删除关联的SKU
    void deleteSku(@Param("id") Integer productId);

    //删除商品属性分类
    void deleteProductAttributeCategory(@Param("id") Integer categoryId);

    //删除商品属性分类的同时删除所属的商品属性
    void deleteProductAttributeByCategoryId(@Param("id") Integer categoryId);

    //单独删除商品属性
    void deleteProductAttribute(ProductAttribute productAttribute);

    //查找商品分类及子分类
    List<ProductCategoryWithChildrenItem> selectProductCategoryWithChildren();
}
