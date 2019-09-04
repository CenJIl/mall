package com.cenjil.repository;

import com.cenjil.entity.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author CenJIl
 * @date 2019/9/4 14:38
 */
@Repository
public interface GoodsRepository extends CrudRepository<Goods ,String> {
}
