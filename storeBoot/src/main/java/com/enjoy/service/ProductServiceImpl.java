package com.enjoy.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.enjoy.entity.ProductEntiry;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductEntiry getDetail(String id) {
        System.out.println(super.getClass().getName()+"被调用一次："+System.currentTimeMillis());
//        return "iponex 售价：1万元";
        ProductEntiry productEntiry= new ProductEntiry();
        productEntiry.setId("001");
        productEntiry.setName("iphonex");
        productEntiry.setPrice(10000);
        return  productEntiry;
    }

    @Override
    public ProductEntiry modify(ProductEntiry product) {
        return null;
    }

    @Override
    public boolean status(String id, boolean upDown) {
        return false;
    }
}
