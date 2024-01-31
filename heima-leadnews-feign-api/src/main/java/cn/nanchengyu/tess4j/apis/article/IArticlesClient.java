package cn.nanchengyu.tess4j.apis.article;

import com.heima.model.article.dtos.ArticleDto;
import com.heima.model.common.dtos.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ClassName: IArticlesClient
 * Package: cn.nanchengyu.apis.article
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/30 16:00
 * @Version 1.0
 */
@FeignClient("leadnews-article")
public interface IArticlesClient {
    @PostMapping("/api/v1/article/save")
     ResponseResult saveArticle(@RequestBody ArticleDto dto);

}
