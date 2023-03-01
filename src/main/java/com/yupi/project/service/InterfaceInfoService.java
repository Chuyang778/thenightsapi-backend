package com.yupi.project.service;

import com.yupi.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yupi.project.model.entity.Post;

/**
* @author Xcy
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-03-01 21:51:33
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    /**
     *
     * @param interfaceInfo
     * @param add
     */
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
