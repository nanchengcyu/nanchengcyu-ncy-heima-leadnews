package com.heima.article.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.heima.model.article.dtos.ArticleHomeDto;
import com.heima.model.article.pojos.ApArticle;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


/**
 * ClassName: ApArticleMapper
 * Package: com.heima.article.mapper
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/27 20:54
 * @Version 1.0
 */
@Mapper
public interface ApArticleMapper extends BaseMapper<ApArticle> {

    /**
     *  加载文章列表
     * @param dto
     * @param type  1 加载更多 2 加载最新
     * @return
     */
     List<ApArticle> loadArticleList(ArticleHomeDto dto, Short type);

     List<ApArticle> findArticleListByLast5days(@Param("dayParam") Date dayParam);

}
