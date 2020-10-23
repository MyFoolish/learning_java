package com.xwcoding.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xwcoding.dubbo.service.ProviderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxiaowei
 * @description
 * @date 2020/9/28 13:14
 */
@RestController
@RequestMapping("/dubbo")
public class ConsumerController {
    @Reference
    private ProviderService providerService;

    @RequestMapping("/showName")
    public String showName() {
        return providerService.showName();
    }
}
