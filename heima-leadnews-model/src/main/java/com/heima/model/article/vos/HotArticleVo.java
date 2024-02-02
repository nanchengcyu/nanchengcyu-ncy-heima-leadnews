package com.heima.model.article.vos;

import com.heima.model.article.pojos.ApArticle;
import lombok.Data;

/**
 * ClassName: HotArticleVo
 * Package: com.heima.model.article.vos
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/2 21:06
 * @Version 1.0
 */
@Data
public class HotArticleVo extends ApArticle {

    /**
     * 文章分值
     */
    private Integer score;
}
