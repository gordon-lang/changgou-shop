package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {

    List<Brand> findAll();

    Brand findById(Integer id);

    Integer addOne(Brand brand);

    Integer updateBrand(Brand brand);

    Integer removeById(Integer id);

    List<Brand> searchBrand(Brand brand);

    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);

}
