package com.ruoyi.school.mapper;

import java.util.List;
import com.ruoyi.school.domain.AppEventReg;

/**
 * userMapper接口
 * 
 * @author ruoyi
 * @date 2025-07-07
 */
public interface AppEventRegMapper 
{
    /**
     * 查询user
     * 
     * @param registrationId user主键
     * @return user
     */
    public AppEventReg selectAppEventRegByRegistrationId(Long registrationId);

    /**
     * 查询user列表
     * 
     * @param appEventReg user
     * @return user集合
     */
    public List<AppEventReg> selectAppEventRegList(AppEventReg appEventReg);

    /**
     * 新增user
     * 
     * @param appEventReg user
     * @return 结果
     */
    public int insertAppEventReg(AppEventReg appEventReg);

    /**
     * 修改user
     * 
     * @param appEventReg user
     * @return 结果
     */
    public int updateAppEventReg(AppEventReg appEventReg);

    /**
     * 删除user
     * 
     * @param registrationId user主键
     * @return 结果
     */
    public int deleteAppEventRegByRegistrationId(Long registrationId);

    /**
     * 批量删除user
     * 
     * @param registrationIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppEventRegByRegistrationIds(Long[] registrationIds);
}
