package com.heima.model.article.dtos;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: ArticleHomeDto
 * Package: com.heima.model.article.pojos.dto
 * Description:
 * DTO是前端需要的参数
 * DTO封装为一个单独的类
 * 包含最大时间、最小时间、分页size、频道ID
 * @Author 南城余
 * @Create 2024/1/27 20:45
 * @Version 1.0
 */
@Data
public class ArticleHomeDto {

    // 最大时间
    Date maxBehotTime;
    // 最小时间
    Date minBehotTime;
    // 分页size
    Integer size;
    // 频道ID
    String tag;
}
