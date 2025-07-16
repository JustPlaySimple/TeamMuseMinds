package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.AppEventMapper;
import com.ruoyi.school.domain.AppEvent;
import com.ruoyi.school.service.IAppEventService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-06
 */
@Service
public class AppEventServiceImpl implements IAppEventService 
{
    @Autowired
    private AppEventMapper appEventMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param eventId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public AppEvent selectAppEventByEventId(Long eventId)
    {
        return appEventMapper.selectAppEventByEventId(eventId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param appEvent 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<AppEvent> selectAppEventList(AppEvent appEvent)
    {
        return appEventMapper.selectAppEventList(appEvent);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param appEvent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertAppEvent(AppEvent appEvent)
    {
        return appEventMapper.insertAppEvent(appEvent);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param appEvent 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateAppEvent(AppEvent appEvent)
    {
        return appEventMapper.updateAppEvent(appEvent);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param eventIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAppEventByEventIds(Long[] eventIds)
    {
        return appEventMapper.deleteAppEventByEventIds(eventIds);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param eventId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteAppEventByEventId(Long eventId)
    {
        return appEventMapper.deleteAppEventByEventId(eventId);
    }
}
