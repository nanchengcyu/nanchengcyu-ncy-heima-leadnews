package com.heima.model.article.dtos;

import com.heima.model.article.pojos.ApArticle;
import lombok.Data;

/**
 * ClassName: ArticleDto
 * Package: com.heima.model.article.dtos
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/30 16:01
 * @Version 1.0
 */
@Data
public class ArticleDto  extends ApArticle {

    private String content;
}
