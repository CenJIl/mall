package com.cenjil.service;


import com.cenjil.entity.Comment;


/**
 * @author CenJIl
 * @date 2019/9/3 11:28
 */
public interface CommentService {


    boolean like(Integer id);

    boolean review(Comment comment);

    boolean review2(Comment comment, Integer id);

    Comment look(Integer id);

    boolean inventory(Integer id);

    Comment select(Integer id);
}
