package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.PollRecordMapper;
import com.ruoyi.school.domain.PollRecord;
import com.ruoyi.school.service.IPollRecordService;

/**
 * poll recordService业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Service
public class PollRecordServiceImpl implements IPollRecordService 
{
    @Autowired
    private PollRecordMapper pollRecordMapper;

    /**
     * 查询poll record
     * 
     * @param recordId poll record主键
     * @return poll record
     */
    @Override
    public PollRecord selectPollRecordByRecordId(Long recordId)
    {
        return pollRecordMapper.selectPollRecordByRecordId(recordId);
    }

    /**
     * 查询poll record列表
     * 
     * @param pollRecord poll record
     * @return poll record
     */
    @Override
    public List<PollRecord> selectPollRecordList(PollRecord pollRecord)
    {
        return pollRecordMapper.selectPollRecordList(pollRecord);
    }

    /**
     * 新增poll record
     * 
     * @param pollRecord poll record
     * @return 结果
     */
    @Override
    public int insertPollRecord(PollRecord pollRecord)
    {
        return pollRecordMapper.insertPollRecord(pollRecord);
    }

    /**
     * 修改poll record
     * 
     * @param pollRecord poll record
     * @return 结果
     */
    @Override
    public int updatePollRecord(PollRecord pollRecord)
    {
        return pollRecordMapper.updatePollRecord(pollRecord);
    }

    /**
     * 批量删除poll record
     * 
     * @param recordIds 需要删除的poll record主键
     * @return 结果
     */
    @Override
    public int deletePollRecordByRecordIds(Long[] recordIds)
    {
        return pollRecordMapper.deletePollRecordByRecordIds(recordIds);
    }

    /**
     * 删除poll record信息
     * 
     * @param recordId poll record主键
     * @return 结果
     */
    @Override
    public int deletePollRecordByRecordId(Long recordId)
    {
        return pollRecordMapper.deletePollRecordByRecordId(recordId);
    }

    @Override
    public int countUserVotes(PollRecord pollRecord)
    {
        return pollRecordMapper.countUserVotes(pollRecord);
    }
}
