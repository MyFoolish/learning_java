package com.xwcoding.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xwcoding.dubbo.service.ProviderService;

/**
 * @author liuxiaowei
 * @description 在服务提供方实现接口
 * @date 2020/9/28 11:19
 */
@Service    //使用阿里提供的注射
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String showName() {
        return "XwCoding";
    }
}
