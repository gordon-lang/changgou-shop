package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.impl.BrandServiceImpl;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/brand" )
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandServiceImpl brandService;


    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping( "findAll" )
    public Result<Brand> findAll() {
     
        List<Brand> brands = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询成功", brands);
    }

    /**
     * 查找
     *
     * @param id
     * @return
     */
    @GetMapping( "findOne/{id}" )
    public Result<Brand> findOne(@PathVariable( value = "id" ) Integer id) {

        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "查询成功", brand);
    }

    /**
     * 新增
     *
     * @param brand
     * @return
     */
    @PostMapping( "addBrand" )
    public Result addBrand(@RequestBody Brand brand) {
        Integer one = brandService.addOne(brand);
        return new Result<>(true, StatusCode.OK, "新增成功", one);

    }

    /**
     * 更新
     *
     * @param brand
     * @return
     */
    @PutMapping( "updateBrand" )
    public Result updateBrand(@RequestBody Brand brand) {

        Integer one = brandService.updateBrand(brand);
        return new Result<>(true, StatusCode.OK, "修改成功", one);

    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping( "remove/{id}" )
    public Result removeById(@PathVariable( value = "id" ) Integer id) {

        Integer one = brandService.removeById(id);
        return new Result<>(true, StatusCode.OK, "删除成功", one);

    }

    /**
     * 条件查询
     *
     * @param brand
     * @return
     */
    @PostMapping( "searchBrand" )
    public Result<Brand> findByCondition(@RequestBody Brand brand) {
        List<Brand> brands = brandService.searchBrand(brand);
        return new Result<Brand>(true, StatusCode.OK, "查询成功", brands);

    }

    /**
     * 分页查询
     *
     * @param page
     * @param size
     * @return
     */
    @PostMapping( "findPage/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody Brand brand, @PathVariable( value = "page" ) Integer page, @PathVariable( value = "size" ) Integer size) {
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);

        return new Result<PageInfo>(true, StatusCode.OK, "查询成功", pageInfo);

    }


}
