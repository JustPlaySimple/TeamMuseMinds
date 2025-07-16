package com.ruoyi.school.service;

import java.util.List;
import com.ruoyi.school.domain.Feedback;

/**
 * submit feedbackService接口
 * 
 * @author ruoyi
 * @date 2025-07-07
 */
public interface IFeedbackService 
{
    /**
     * 查询submit feedback
     * 
     * @param feedbackId submit feedback主键
     * @return submit feedback
     */
    public Feedback selectFeedbackByFeedbackId(Long feedbackId);

    /**
     * 查询submit feedback列表
     * 
     * @param feedback submit feedback
     * @return submit feedback集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增submit feedback
     * 
     * @param feedback submit feedback
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改submit feedback
     * 
     * @param feedback submit feedback
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 批量删除submit feedback
     * 
     * @param feedbackIds 需要删除的submit feedback主键集合
     * @return 结果
     */
    public int deleteFeedbackByFeedbackIds(Long[] feedbackIds);

    /**
     * 删除submit feedback信息
     * 
     * @param feedbackId submit feedback主键
     * @return 结果
     */
    public int deleteFeedbackByFeedbackId(Long feedbackId);
}
