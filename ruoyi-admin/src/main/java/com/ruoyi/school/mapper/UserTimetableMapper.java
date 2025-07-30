package com.ruoyi.school.mapper;

import java.util.List;
import com.ruoyi.school.domain.UserTimetable;

/**
 * timetableMapper接口
 * 
 * @author chenc
 * @date 2025-07-30
 */
public interface UserTimetableMapper 
{
    /**
     * 查询timetable
     * 
     * @param id timetable主键
     * @return timetable
     */
    public UserTimetable selectUserTimetableById(Long id);

    /**
     * 查询timetable列表
     * 
     * @param userTimetable timetable
     * @return timetable集合
     */
    public List<UserTimetable> selectUserTimetableList(UserTimetable userTimetable);

    /**
     * 新增timetable
     * 
     * @param userTimetable timetable
     * @return 结果
     */
    public int insertUserTimetable(UserTimetable userTimetable);

    /**
     * 修改timetable
     * 
     * @param userTimetable timetable
     * @return 结果
     */
    public int updateUserTimetable(UserTimetable userTimetable);

    /**
     * 删除timetable
     * 
     * @param id timetable主键
     * @return 结果
     */
    public int deleteUserTimetableById(Long id);

    /**
     * 批量删除timetable
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserTimetableByIds(Long[] ids);
}
