package com.heima.model.mess;

import lombok.Data;

/**
 * ClassName: UpdateArticleMes
 * Package: com.heima.model.mess
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/3 19:16
 * @Version 1.0
 */
@Data
public class UpdateArticleMess {
    /**
     * 修改文章的字段类型
     */
    private UpdateArticleType type;

    /**
     * 文章ID
     */
    private Long articleId;
    /**
     * 修改数据的增量，可为正负
     */
    private Integer add;
    public enum UpdateArticleType{
        COLLECTION,COMMENT,LIKES,VIEWS

    }
}
