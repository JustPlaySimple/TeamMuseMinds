package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.AppEventRegMapper;
import com.ruoyi.school.domain.AppEventReg;
import com.ruoyi.school.service.IAppEventRegService;

/**
 * userService业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-07
 */
@Service
public class AppEventRegServiceImpl implements IAppEventRegService 
{
    @Autowired
    private AppEventRegMapper appEventRegMapper;

    /**
     * event
     * 
     * @param registrationId user主键
     * @return user
     */
    @Override
    public AppEventReg selectAppEventRegByRegistrationId(Long registrationId)
    {
        return appEventRegMapper.selectAppEventRegByRegistrationId(registrationId);
    }

    /**
     * search Event registration list
     * 
     * @param appEventReg event registration
     * @return user
     */
    @Override
    public List<AppEventReg> selectAppEventRegList(AppEventReg appEventReg)
    {
        return appEventRegMapper.selectAppEventRegList(appEventReg);
    }

    /**
     * 新增event registration
     * 
     * @param appEventReg user
     * @return 结果
     */
    @Override
    public int insertAppEventReg(AppEventReg appEventReg)
    {
        return appEventRegMapper.insertAppEventReg(appEventReg);
    }

    /**
     * 修改user
     * 
     * @param appEventReg user
     * @return 结果
     */
    @Override
    public int updateAppEventReg(AppEventReg appEventReg)
    {
        return appEventRegMapper.updateAppEventReg(appEventReg);
    }

    /**
     * 批量删除user
     * 
     * @param registrationIds 需要删除的user主键
     * @return 结果
     */
    @Override
    public int deleteAppEventRegByRegistrationIds(Long[] registrationIds)
    {
        return appEventRegMapper.deleteAppEventRegByRegistrationIds(registrationIds);
    }

    /**
     * 删除user信息
     * 
     * @param registrationId user主键
     * @return 结果
     */
    @Override
    public int deleteAppEventRegByRegistrationId(Long registrationId)
    {
        return appEventRegMapper.deleteAppEventRegByRegistrationId(registrationId);
    }
}
