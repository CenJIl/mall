package com.cenjil.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author CenJIl
 * @date 2019/9/3 15:06
 */
@Data
@Entity
@ApiModel("用户评论")
public class Comment {

    @Id
    @ApiModelProperty("用户评论的id")
    @Column(length = 36)
    private String id;

    @ApiModelProperty("用户评论")
    private String review;

    @ApiModelProperty("用户评分")
    @Pattern(regexp = "[0-9]+")
    private Integer point;

    @ApiModelProperty("点赞数量")
    @Pattern(regexp = "[0-9]+")
    private Integer like;

    @ApiModelProperty("评论的时间")
    private Date createTime;
}
