//package com.cenjil.service.impl;
//
//import com.cenjil.boot.mapper.CommentMapper;
//import com.cenjil.boot.mapper.GoodsMapper;
//import com.cenjil.dto.GoodDto;
//import com.cenjil.entity.Goods;
//import com.cenjil.param.GoodParam;
//import org.springframework.stereotype.Service;
//import org.springframework.util.Assert;
//
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
///**
// * @author 涂文宇
// * @date 2018/7/26 15:57
// */
//@Service
//public class GoodServiceImpl {
//    private GoodsMapper mapper;
//    private CommentMapper commentMapper;
//
//    public GoodServiceImpl(GoodsMapper mapper, CommentMapper commentMapper) {
//        this.mapper = mapper;
//        this.commentMapper = commentMapper;
//    }
//
//    /**
//     * 上架商品
//     *
//     * @param goodParam 商品基本信息
//     * @return 是否上架成功
//     */
//    public boolean add(GoodParam goodParam) {
//        Goods goods = new Goods();
//        Assert.isTrue(goodParam.getPrice().compareTo(goodParam.getDiscount()) > -1, "折扣不能超过价格!");
//        goods.setPrice(goodParam.getPrice());
//        goods.setDescribe(goodParam.getDescribe());
//        goods.setDiscount(goodParam.getDiscount());
//        goods.setPicture(goodParam.getPicture());
//        goods.setInventory(goodParam.getInventory());
//        goods.setCreateTime(new Date());
//        return mapper.add(goods) > 0;
//    }
//
//    /**
//     * 通过id查看商品详情
//     *
//     * @param id 传入参数id
//     * @return 一个商品详情的新建类
//     */
//    public GoodDto findById(Integer id) {
//        GoodDto goodDto = new GoodDto();
//        Goods goods = mapper.selectById(id);
//        goodDto.setCreateTime(goods.getCreateTime());
//        goodDto.setDescribe(goods.getDescribe());
//        goodDto.setInventory(goods.getInventory());
//        goodDto.setDiscount(goods.getDiscount());
//        goodDto.setPicture(goods.getPicture());
//        goodDto.setPrice(goods.getPrice());
//        String comment = goods.getComment();
//        if (comment.isEmpty()) {
//            return goodDto;
//        } else {
//            List<Integer> commentIds = Stream.of(comment.split(",")).map(Integer::valueOf).collect(Collectors.toList());
//            goodDto.setComments(commentMapper.selectByIds(commentIds));
//            return goodDto;
//        }
//    }
//
//    /**
//     * 修改商品信息
//     *
//     * @param goodParam 修改的传入参数
//     * @return 是否修改成功
//     */
//    public Boolean update(GoodParam goodParam) {
//        Goods goods = new Goods();
//        goods.setId(goodParam.getId());
//        goods.setPrice(goodParam.getPrice());
//        goods.setDescribe(goodParam.getDescribe());
//        goods.setDiscount(goodParam.getDiscount());
//        goods.setPicture(goodParam.getPicture());
//        return mapper.update(goods) > 0;
//    }
//
//
//    /**
//     *
//     * @param id
//     * @return
//     */
//    public List<Goods> selectOne(Integer id) {
//        return  null;
//    }
//}
