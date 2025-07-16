package com.ruoyi.school.mapper;

import java.util.List;
import com.ruoyi.school.domain.Poll;

/**
 * pollMapper接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface PollMapper 
{
    /**
     * 查询poll
     * 
     * @param pollId poll主键
     * @return poll
     */
    public Poll selectPollByPollId(Long pollId);

    /**
     * 查询poll列表
     * 
     * @param poll poll
     * @return poll集合
     */
    public List<Poll> selectPollList(Poll poll);

    /**
     * 新增poll
     * 
     * @param poll poll
     * @return 结果
     */
    public int insertPoll(Poll poll);

    /**
     * 修改poll
     * 
     * @param poll poll
     * @return 结果
     */
    public int updatePoll(Poll poll);

    /**
     * 删除poll
     * 
     * @param pollId poll主键
     * @return 结果
     */
    public int deletePollByPollId(Long pollId);

    /**
     * 批量删除poll
     * 
     * @param pollIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePollByPollIds(Long[] pollIds);
}
