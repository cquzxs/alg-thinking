package com.zxs.ssh.template.service.user.api;

import com.zxs.ssh.template.model.db.UserModel;

import java.util.Map;

/**
 * Project Name:ssh-template
 * File Name:IUserService
 * Package Name:com.zxs.ssh.template.service.user.api
 * Date:2018/12/11
 * Author:zengxueshan
 * Description:用户
 * Copyright (c) 2018, 重庆云凯科技有限公司 All Rights Reserved.
 */


public interface IUserService {
    /**
     * #1 添加一个model
     *
     * @return 添加个数
     * @throws Exception 异常
     */
    Object add() throws Exception;

    /**
     * #2 删除一个model
     *
     * @return 删除个数
     * @throws Exception 异常
     */
    Object delete(long modelId) throws Exception;

    /**
     * #3 删除多个model
     *
     * @return 删除个数
     * @throws Exception 异常
     */
    Object deleteMany() throws Exception;

    /**
     * #4 更新一个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    Object update(long modelId) throws Exception;

    /**
     * #5 更新多个model
     *
     * @return 更新个数
     * @throws Exception 异常
     */
    Object updateMany() throws Exception;

    /**
     * #6 查询一个model
     *
     * @return 查询结果
     * @throws Exception 异常
     */
    UserModel findOne(long modelId) throws Exception;

    /**
     * #7 分页查询
     *
     * @param pageIndex 页码
     * @param pageSize 页面大小
     * @return 查询结果
     * @throws Exception 异常
     */
    Map<String, Object> findPage(int pageIndex, int pageSize) throws Exception;

    /**
     * #8 查询结果总数
     *
     * @return 查询结果总数
     * @throws Exception 异常
     */
    long getTotalCount() throws Exception;
}
