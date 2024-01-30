package com.heima.article.service.impl;

import com.heima.article.service.WmNewsAutoScanService;
import com.heima.model.wemedia.pojos.WmNews;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * ClassName: WmNewsAutoScanServiceImpl
 * Package: com.heima.article.service.impl
 * Description:
 *
 * @Author 南城余
 * @Create 2024/1/30 17:04
 * @Version 1.0
 */
@Service
@Slf4j
@Transactional
public class WmNewsAutoScanServiceImpl implements WmNewsAutoScanService {
    @Override
    public void autoScanWmNews(Integer id) {
        //1. 查询自媒体文章
        //Wmnews wmnews =  wmNewsMapper.selectById(id);


        //2.审核文本内容 阿里云接口

        //3.审核图片 阿里云接口

        //4.审核成功，保存app端的相关文章数据


    }
    private Map<String,Object> handleTextAndImages(WmNews wmNews){
        return null;
    }
}
