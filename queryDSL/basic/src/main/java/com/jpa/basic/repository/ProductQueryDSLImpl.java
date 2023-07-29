package com.jpa.basic.repository;

import com.jpa.basic.entity.Product;
import com.jpa.basic.entity.QProduct;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.util.List;

import static com.jpa.basic.entity.QProduct.product;

@Slf4j
public class ProductQueryDSLImpl implements ProductQueryDSL {
    @Autowired
    private JPAQueryFactory query;

    @Override
    public List<Product> findAll() {
        log.info("======================================");
//        static import를 통해서 선언 없이 바로 product를 사용할 수 있다.
//        select()에 파라미터를 비워놓을 수 없다.
//        fetch()는 여러 개의 정보를 가져올 때 사용한다.
        final List<Product> products = query.select(product).from(product).fetch();
        return products;
    }

    @Override
    public Page<Product> findAllWithPaging(Pageable pageable) {
        final List<Product> products = query.select(product).from(product)
                .orderBy(product.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

//        fetchOne(): 한 개의 정보를 가져올 때 사용한다.
        final Long count = query.select(product.count()).from(product).fetchOne();


        return new PageImpl<>(products, pageable, count);
    }

    @Override
    public Slice<Product> findAllWithSlice(Pageable pageable) {
//        사용자가 요청한 페이지의 게시글 개수를 +1개 가져온다.
//        다음 페이지 유무를 알아야 화면 처리가 가능하기 때문!
        final List<Product> products = query.selectFrom(product)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize() + 1)
                .orderBy(product.id.desc())
                .fetch();

        boolean hasNext = false;

//        정말 한 개 더 가져왔다면, 다음 페이지가 있다는 의미이고,
//        원래 요청한 개수랑 동일하다면 다음 페이지가 없다는 의미이다.
        if(products.size() > pageable.getPageSize()){
            hasNext = true;
//            실제 화면에서는 요청한 개수만 필요하기 때문에
//            다음 페이지 유무 검사를 위해 가져온 마지막 게시글은 삭제해준다.
            products.remove(pageable.getPageSize());
        }

//        Slice의 hasNext()를 사용할 경우 전달한 hasNext값이 나온다.
        return new SliceImpl<>(products, pageable, hasNext);
    }

    //    @Override
//    public void updateById(Product product) {
//        query.update(QProduct.product).set(QProduct.product.productName, product.getProductName())
//                .where(QProduct.product.id.eq(product.getId())).execute();
//    }
    @Override
    public void updateById(Product product) {
        query.update(QProduct.product).set(QProduct.product.productName, product.getProductName())
                .set(QProduct.product.productPrice, product.getProductPrice())
                .set(QProduct.product.productStock, product.getProductStock())
                .where(QProduct.product.id.eq(product.getId())).execute();
    }

    @Override
    public void updatePrices() {
        query.update(product)
                .set(product.productPrice, product.productPrice.doubleValue().multiply(1.1).intValue())
                .where(product.productPrice.loe(
                        JPAExpressions.select(product.productPrice.avg()).from(product)
                )).execute();
    }

    @Override
    public List<Product> findAllByProductName(String keyword) {
        return query.selectFrom(product)
                .where(product.productName.contains(keyword))
                .fetch();
    }


    @Override
    public double findAvg() {
        return query.select(product.productPrice.avg()).from(product).fetchOne();
    }

    @Override
    public void deleteByProductName(String productName) {
        query.delete(product).where(product.productName.eq(productName)).execute();
    }
}