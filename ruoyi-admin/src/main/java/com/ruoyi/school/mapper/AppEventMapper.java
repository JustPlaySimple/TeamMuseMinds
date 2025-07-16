package com.ruoyi.school.mapper;

import java.util.List;
import com.ruoyi.school.domain.AppEvent;

/**
 * 【请填写功能名称】Mapper接口
 *
 * @author ruoyi
 * @date 2025-07-06
 */
public interface AppEventMapper
{
    /**
     * 查询【请填写功能名称】
     *
     * @param eventId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public AppEvent selectAppEventByEventId(Long eventId);

    /**
     * 查询【请填写功能名称】列表
     *
     * @param appEvent 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<AppEvent> selectAppEventList(AppEvent appEvent);

    /**
     * 新增【请填写功能名称】
     *
     * @param appEvent 【请填写功能名称】
     * @return 结果
     */
    public int insertAppEvent(AppEvent appEvent);

    /**
     * 修改【请填写功能名称】
     *
     * @param appEvent 【请填写功能名称】
     * @return 结果
     */
    public int updateAppEvent(AppEvent appEvent);

    /**
     * 删除【请填写功能名称】
     *
     * @param eventId 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteAppEventByEventId(Long eventId);

    /**
     * 批量删除【请填写功能名称】
     *
     * @param eventIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAppEventByEventIds(Long[] eventIds);
}
