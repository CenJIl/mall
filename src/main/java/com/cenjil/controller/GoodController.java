//package com.cenjil.controller;
//
//
//
//
//import com.cenjil.entity.Goods;
//
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * @author 涂文宇
// * @date 2018/7/26 15:56
// */
//@Controller
//@EnableAutoConfiguration
//@RequestMapping("good")
//@Api(tags = "对商品的操作")
//public class GoodController {
//
//    private final GoodService service;
//
//    public GoodController(GoodService service) {
//        this.service = service;
//    }
//
//    @PutMapping("/add")
//    @ApiOperation("上架商品")
//    public String add(@RequestBody GoodParam goodParam) {
//        if (service.add(goodParam)) {
//            return "上架成功!";
//        } else {
//            return "上架失败!";
//        }
//    }
//
//    @GetMapping("/find/{id}")
//    @ApiOperation("查看商品详情")
//    public GoodDto find(@PathVariable("id") Integer id) {
//        return service.findById(id);
//    }
//
//    @PutMapping("/update")
//    @ApiOperation("修改商品信息")
//    public String update(@RequestBody GoodParam goodParam) {
//        if (service.update(goodParam)) {
//            return "修改成功!";
//        } else {
//            return "修改失败!";
//        }
//    }
//
//    @PostMapping("/list")
//    @ApiOperation("展示商品列表")
//    public List<GoodListDto> list(@RequestBody GoodPageParam pageParam) {
//        return null;
//    }
//
//    @PostMapping("/select/{id}")
//    @ApiOperation("用通用mapper的内置方法")
//    public List<Goods> selectOne(@PathVariable("id") Integer id) {
//        return service.selectOne(id);
//    }
//}
