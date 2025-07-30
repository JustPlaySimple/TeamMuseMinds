package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.PollMapper;
import com.ruoyi.school.mapper.PollRecordMapper;
import com.ruoyi.school.domain.Poll;
import com.ruoyi.school.service.IPollService;

/**
 * pollService业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Service
public class PollServiceImpl implements IPollService 
{
    @Autowired
    private PollMapper pollMapper;

    @Autowired
    private PollRecordMapper pollRecordMapper;


    /**
     * 查询poll
     * 
     * @param pollId poll主键
     * @return poll
     */
    @Override
    public Poll selectPollByPollId(Long pollId)
    {
        return pollMapper.selectPollByPollId(pollId);
    }

    /**
     * 查询poll列表
     * 
     * @param poll poll
     * @return poll
     */
    @Override
    public List<Poll> selectPollList(Poll poll)
    {
        return pollMapper.selectPollList(poll);
    }

    /**
     * 新增poll
     * 
     * @param poll poll
     * @return 结果
     */
    @Override
    public int insertPoll(Poll poll)
    {
        return pollMapper.insertPoll(poll);
    }

    /**
     * 修改poll
     * 
     * @param poll poll
     * @return 结果
     */
    @Override
    public int updatePoll(Poll poll)
    {
        return pollMapper.updatePoll(poll);
    }

    /**
     * 批量删除poll
     * 
     * @param pollIds 需要删除的poll主键
     * @return 结果
     */
    @Override
    public int deletePollByPollIds(Long[] pollIds)
    {
        return pollMapper.deletePollByPollIds(pollIds);
    }

    /**
     * 删除poll信息
     * 
     * @param pollId poll主键
     * @return 结果
     */
    @Override
    public int deletePollByPollId(Long pollId)
    {
        return pollMapper.deletePollByPollId(pollId);
    }



}
