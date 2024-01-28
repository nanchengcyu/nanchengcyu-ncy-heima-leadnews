package com.heima.wemedia.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.heima.file.service.FileStorageService;
import com.heima.model.common.dtos.PageResponseResult;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.common.enums.AppHttpCodeEnum;
import com.heima.model.wemedia.dtos.WmMaterialDto;
import com.heima.model.wemedia.pojos.WmMaterial;
import com.heima.utils.thread.WmThreadLocalUtil;
import com.heima.wemedia.mapper.WmMaterialMapper;

import com.heima.wemedia.service.WmMaterialService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class WmMaterialServiceImpl extends ServiceImpl<WmMaterialMapper, WmMaterial> implements WmMaterialService {


    @Resource
    private FileStorageService fileStorageService;

    @Override
    public ResponseResult uploadPicture(MultipartFile multipartFile) {
        //1. 判断参数状态
        if (multipartFile == null && multipartFile.getSize() == 0) {
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID);
        }
        //2.上传图片到minio中
        //保证文件名称的不一致 用uuid实现
        String fileName = UUID.randomUUID().toString().replace("-", "");
        //后缀
        String originalFilename = multipartFile.getOriginalFilename();
        String postFix = originalFilename.substring(originalFilename.lastIndexOf("."));
        String fileId = null;
        try {
            fileId = fileStorageService.uploadImgFile("", fileName + postFix, multipartFile.getInputStream());
            log.info("上传图片到Minio中，fileId:{}", fileId);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("WmMaterialServiceImpl- 上传文件失败");
        }
        //保存到数据库中
        WmMaterial wmMaterial = new WmMaterial();
        wmMaterial.setUserId(WmThreadLocalUtil.getUser().getId());
        wmMaterial.setUrl(fileId);
        wmMaterial.setIsCollection((short) 0);
        wmMaterial.setType((short) 0);
        wmMaterial.setCreatedTime(new Date());
        save(wmMaterial);

        return ResponseResult.okResult(wmMaterial);
    }

    @Override
    public ResponseResult findList(WmMaterialDto dto) {
        //1.参数
        dto.checkParam();
        //2.分页查询
        IPage page = new Page();
        LambdaQueryWrapper<WmMaterial> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //是否收藏
        if (dto.getIsCollection() != null && dto.getIsCollection() == 1) {
            lambdaQueryWrapper.eq(WmMaterial::getIsCollection, dto.getIsCollection());
        }
        //按照用户查询
        lambdaQueryWrapper.eq(WmMaterial::getUserId, WmThreadLocalUtil.getUser().getId());
        //按照时间排序
        lambdaQueryWrapper.orderByDesc(WmMaterial::getCreatedTime);

        page = page(page, lambdaQueryWrapper);

        PageResponseResult responseResult = new PageResponseResult(dto.getPage(), dto.getSize(), (int) page.getTotal());
        responseResult.setData(page.getRecords());
        return responseResult;
    }
}