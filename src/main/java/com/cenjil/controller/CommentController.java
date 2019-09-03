package com.cenjil.controller;


import com.cenjil.entity.Comment;
import com.cenjil.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
@RequestMapping("/comment")
@Api(tags = "对评论的操作")
public class CommentController {

    private final CommentService service;

    @Autowired
    public CommentController(CommentService service) {
        this.service = service;
    }

    @PutMapping("/like/{id}")
    @ApiOperation("给评论点赞")
    public String like(@PathVariable("id") Integer id) {
        if (service.like(id)) {
            return "点赞成功!";
        } else {
            return "点赞失败!";
        }
    }

    @PutMapping("/review")
    @ApiOperation("给商品评论")
    public String review(@RequestBody Comment comment) {
        boolean b;
        b = service.review(comment);
        if (b) {
            return "评论成功";
        } else {
            return "评论失败";
        }
    }

    @PutMapping("/review2/{id}")//传入的id是商品的id确定对哪一个商品评论
    @ApiOperation("给商品评论(改)")
    public String review2(@RequestBody Comment comment,
                          @PathVariable("id") Integer id) {
        if (service.review2(comment, id)) {
            return "评论成功";
        } else {
            return "评论失败";
        }
    }


    @GetMapping("/look/{id}")
    @ApiOperation("查看商品评论")
    public Comment look(@PathVariable("id") Integer id) {
        return service.look(id);

    }

    @PutMapping("/inventory/{id}")
    @ApiOperation("商品库存")
    public String inventory(@PathVariable("id") Integer id) {
        if (service.inventory(id)) {
            return "购买成功";
        } else {
            return "商品不足";
        }
    }

    @GetMapping("/select/{id}")
    @ApiOperation("用通用mapper的内置方法")
    public Comment select(Integer id) {
        return service.select(id);
    }
}
