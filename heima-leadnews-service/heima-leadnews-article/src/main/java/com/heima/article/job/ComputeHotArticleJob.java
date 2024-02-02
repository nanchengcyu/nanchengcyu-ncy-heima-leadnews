package com.heima.article.job;

import com.heima.article.service.HotArticleService;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ClassName: ComputeHotArticleJob
 * Package: com.heima.article.job
 * Description:
 *
 * @Author 南城余
 * @Create 2024/2/2 22:38
 * @Version 1.0
 */
@Component
@Slf4j
public class ComputeHotArticleJob {
    @Autowired
    private HotArticleService hotArticleService;
    @XxlJob("computeHotArticleJob")
    public void handle(){
        log.info("热文章分值计算调度开始执行");
        hotArticleService.computeHotArticle();
        log.info("热文章分值计算调度结束");
    }


}
