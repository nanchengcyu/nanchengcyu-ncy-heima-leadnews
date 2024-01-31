package com.heima.article.feign;

import cn.nanchengyu.tess4j.apis.article.IArticlesClient;
import com.heima.article.service.ApArticleService;
import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: ArticleClient
 * Package: com.heima.article.controller.v1
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/30 16:07
 * @Version 1.0
 */
@RestController
public class ArticleClient implements IArticlesClient {
    @Autowired
    private ApArticleService apArticleService;
    @PostMapping("/api/v1/article/save")

    public ResponseResult saveArticle(@RequestBody ArticleDto dto) {
        return apArticleService.saveArticle(dto);
    }

}
