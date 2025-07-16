package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.FeedbackMapper;
import com.ruoyi.school.domain.Feedback;
import com.ruoyi.school.service.IFeedbackService;

/**
 * submit feedbackService业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-07
 */
@Service
public class FeedbackServiceImpl implements IFeedbackService 
{
    @Autowired
    private FeedbackMapper feedbackMapper;

    /**
     * 查询submit feedback
     * 
     * @param feedbackId submit feedback主键
     * @return submit feedback
     */
    @Override
    public Feedback selectFeedbackByFeedbackId(Long feedbackId)
    {
        return feedbackMapper.selectFeedbackByFeedbackId(feedbackId);
    }

    /**
     * 查询submit feedback列表
     * 
     * @param feedback submit feedback
     * @return submit feedback
     */
    @Override
    public List<Feedback> selectFeedbackList(Feedback feedback)
    {
        return feedbackMapper.selectFeedbackList(feedback);
    }

    /**
     * 新增submit feedback
     * 
     * @param feedback submit feedback
     * @return 结果
     */
    @Override
    public int insertFeedback(Feedback feedback)
    {
        return feedbackMapper.insertFeedback(feedback);
    }

    /**
     * 修改submit feedback
     * 
     * @param feedback submit feedback
     * @return 结果
     */
    @Override
    public int updateFeedback(Feedback feedback)
    {
        return feedbackMapper.updateFeedback(feedback);
    }

    /**
     * 批量删除submit feedback
     * 
     * @param feedbackIds 需要删除的submit feedback主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByFeedbackIds(Long[] feedbackIds)
    {
        return feedbackMapper.deleteFeedbackByFeedbackIds(feedbackIds);
    }

    /**
     * 删除submit feedback信息
     * 
     * @param feedbackId submit feedback主键
     * @return 结果
     */
    @Override
    public int deleteFeedbackByFeedbackId(Long feedbackId)
    {
        return feedbackMapper.deleteFeedbackByFeedbackId(feedbackId);
    }
}
