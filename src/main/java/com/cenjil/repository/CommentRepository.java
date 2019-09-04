package com.cenjil.repository;

import com.cenjil.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author CenJIl
 * @date 2019/9/4 14:38
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, String> {
}
