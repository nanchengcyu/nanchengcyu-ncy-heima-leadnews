package com.heima.article.service.impl;

import com.heima.article.mapper.ApArticleMapper;
import com.heima.article.service.HotArticleService;
import com.heima.common.constants.ArticleConstants;
import com.heima.model.article.pojos.ApArticle;
import com.heima.model.article.vos.HotArticleVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: HotArticleServiceImpl
 * Package: com.heima.article.service.impl
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/2 20:59
 * @Version 1.0
 */
@Service
@Slf4j
@Transactional
public class HotArticleServiceImpl implements HotArticleService {
    @Autowired
    private ApArticleMapper apArticleMapper;

    @Override
    public void computeHotArticle() {
        //1.查询前五天的文章数据
        Date dateParam = DateTime.now().minusDays(5).toDate();

        List<ApArticle> apArticleList = apArticleMapper.findArticleListByLast5days(dateParam);
        //2.计算文章的分值
        List<HotArticleVo> hotArticleVoList = computeHotArticle(apArticleList);

        //3.为每个频道缓存30条分支较高的文章
        cacheTagToRedis(hotArticleVoList);

    }

    private void cacheTagToRedis(List<HotArticleVo> hotArticleVoList) {
    }

    private List<HotArticleVo> computeHotArticle(List<ApArticle> apArticleList) {
        ArrayList<HotArticleVo> hotArticleVoList = new ArrayList<>();
        if (apArticleList != null && apArticleList.size() > 0) {
            for (ApArticle apArticle : apArticleList) {
                HotArticleVo hot = new HotArticleVo();
                BeanUtils.copyProperties(apArticle, hot);
                Integer score = computeScore(apArticle);
                hot.setScore(score);
                hotArticleVoList.add(hot);
            }

        }
        return hotArticleVoList;

    }

    private Integer computeScore(ApArticle apArticle) {
        Integer score = 0;
        if (apArticle.getLikes() != null) {
            score += apArticle.getLikes() * ArticleConstants.HOT_ARTICLE_LIKE_WEIGHT;
        }
        //其余省略
        return score;
    }
}
