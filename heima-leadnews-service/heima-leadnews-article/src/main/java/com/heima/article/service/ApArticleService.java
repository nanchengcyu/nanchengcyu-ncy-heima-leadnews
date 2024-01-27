package com.heima.article.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.common.dtos.ResponseResult;

/**
 * ClassName: ApArticleService
 * Package: com.heima.article.service
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/27 21:06
 * @Version 1.0
 */
public interface ApArticleService extends IService<ApArticle> {
    public ResponseResult load(ArticleHomeDto dto, Short type);
}
