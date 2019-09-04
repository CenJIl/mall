package com.cenjil.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 涂文宇
 * @date 2019/9/3 9:18
 */
@Data
@Entity
@ApiModel("商品基本信息")
public class Goods {

    @Id
    @ApiModelProperty("商品id")
    @Column( length = 36)
    private String id;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("优惠价格(减免的部分)")
    private BigDecimal discount;

    @ApiModelProperty("图片的url地址")
    private String picture;

    @ApiModelProperty("库存的数量")
    private Integer inventory;

    @ApiModelProperty("上架的时间")
    private Date createTime;

    @ApiModelProperty("用户评论(用逗号分隔的字符串) 例:1,2,3")
    private String comment;

    @ApiModelProperty("删除时间")
    private Date deleteTime;

    @ApiModelProperty("商品描述")
    private String describe;

}

