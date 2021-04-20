package cn.enjoy.service.impl;

import cn.enjoy.mapper.ProductMapper;
import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {

    @Resource
    private ProductMapper productMapper;


    public Product get(long id) {
        return productMapper.findById(id);
    }


    public boolean add(Product product) {
        return productMapper.create(product);
    }


    public List<Product> list() {
        return productMapper.findAll();
    }
}