package com.ruoyi.school.service;

import java.util.List;
import com.ruoyi.school.domain.UserTimetable;
import org.springframework.web.multipart.MultipartFile;


/**
 * timetableService接口
 * 
 * @author chenc
 * @date 2025-07-30
 */
public interface IUserTimetableService 
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
     * 批量删除timetable
     * 
     * @param ids 需要删除的timetable主键集合
     * @return 结果
     */
    public int deleteUserTimetableByIds(Long[] ids);

    /**
     * 删除timetable信息
     * 
     * @param id timetable主键
     * @return 结果
     */
    public int deleteUserTimetableById(Long id);


    public List<UserTimetable> scanImageAndGenerateTimetable(MultipartFile file, Long userId);

}
