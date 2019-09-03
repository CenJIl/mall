package com.cenjil.service.impl;

import com.cenjil.entity.Comment;
import com.cenjil.repository.CommentRepository;
import com.cenjil.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author CenJIl
 * @date 2019/9/3 11:39
 */
@Service
public class CommentServiceImpl implements CommentService {
    final private CommentRepository repository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.repository = commentRepository;
    }

    @Override
    public boolean like(Integer id) {
        Optional<Comment> commentOptional = repository.findById(id.toString());
        if (commentOptional.isEmpty()){
            return false;
        }
        else {
            Comment comment=commentOptional.get();
            comment.setLike(comment.getLike()+1);
            return  true;
        }
    }

    @Override
    public boolean review(Comment comment) {
        return false;
    }

    @Override
    public boolean review2(Comment comment, Integer id) {
        return false;
    }

    @Override
    public Comment look(Integer id) {
        return null;
    }

    @Override
    public boolean inventory(Integer id) {
        return false;
    }

    @Override
    public Comment select(Integer id) {
        return null;
    }
}
