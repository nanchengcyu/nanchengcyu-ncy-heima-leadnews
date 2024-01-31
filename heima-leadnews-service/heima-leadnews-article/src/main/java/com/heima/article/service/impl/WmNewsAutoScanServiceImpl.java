package com.heima.article.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.heima.article.service.WmNewsAutoScanService;
import com.heima.model.wemedia.pojos.WmNews;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        //存储纯文本内容
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> images = new ArrayList<>();

        //1. 从自媒体文章的内容种提取文本和图片
        if(StringUtils.isNotBlank(wmNews.getContent())){
            List<Map> maps = JSONArray.parseArray(wmNews.getContent(), Map.class);
            for (Map map:maps){
                if (map.get("type").equals("text")){
                    stringBuilder.append(map.get("value"));
                }
                if (map.get("type").equals("image")){
                    images.add((String) map.get("value"));
                }
            }

        }
        //2.提取文章的封面图片
        if (StringUtils.isNotBlank(wmNews.getImages())){
            String[] split = wmNews.getImages().split(",");
            images.addAll(Arrays.asList(split));
        }
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("content",stringBuilder.toString());
        resultMap.put("image",images);
        return resultMap;
    }
}
