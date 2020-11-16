package com.changgou.service.impl;

import com.changgou.dao.BrandMapper;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {

        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {

        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addOne(Brand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public Integer updateBrand(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public Integer removeById(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> searchBrand(Brand brand) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (!StringUtils.isEmpty(brand.getId())) {
                criteria.andEqualTo("id", brand.getId());
            }
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }

            if (!StringUtils.isEmpty(brand.getImage())) {
                criteria.andLike("image", "%" + brand.getName() + "%");

            }
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }

        }

        return brandMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand,Integer page, Integer size) {

        PageHelper.startPage(page, size);
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (brand != null) {
            if (!StringUtils.isEmpty(brand.getId())) {
                criteria.andEqualTo("id", brand.getId());
            }
            if (!StringUtils.isEmpty(brand.getName())) {
                criteria.andLike("name", "%" + brand.getName() + "%");
            }

            if (!StringUtils.isEmpty(brand.getImage())) {
                criteria.andLike("image", "%" + brand.getName() + "%");

            }
            if (!StringUtils.isEmpty(brand.getLetter())) {
                criteria.andEqualTo("letter", brand.getLetter());
            }

        }
        List<Brand> brands = brandMapper.selectByExample(example);
        return new PageInfo<>(brands);


    }
}
