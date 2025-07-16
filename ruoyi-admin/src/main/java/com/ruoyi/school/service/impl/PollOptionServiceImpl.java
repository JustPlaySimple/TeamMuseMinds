package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.PollOptionMapper;
import com.ruoyi.school.domain.PollOption;
import com.ruoyi.school.service.IPollOptionService;

/**
 * poll optionService业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@Service
public class PollOptionServiceImpl implements IPollOptionService 
{
    @Autowired
    private PollOptionMapper pollOptionMapper;

    /**
     * 查询poll option
     * 
     * @param optionId poll option主键
     * @return poll option
     */
    @Override
    public PollOption selectPollOptionByOptionId(Long optionId)
    {
        return pollOptionMapper.selectPollOptionByOptionId(optionId);
    }

    /**
     * 查询poll option列表
     * 
     * @param pollOption poll option
     * @return poll option
     */
    @Override
    public List<PollOption> selectPollOptionList(PollOption pollOption)
    {
        return pollOptionMapper.selectPollOptionList(pollOption);
    }

    /**
     * 新增poll option
     * 
     * @param pollOption poll option
     * @return 结果
     */
    @Override
    public int insertPollOption(PollOption pollOption)
    {
        return pollOptionMapper.insertPollOption(pollOption);
    }

    /**
     * 修改poll option
     * 
     * @param pollOption poll option
     * @return 结果
     */
    @Override
    public int updatePollOption(PollOption pollOption)
    {
        return pollOptionMapper.updatePollOption(pollOption);
    }

    /**
     * 批量删除poll option
     * 
     * @param optionIds 需要删除的poll option主键
     * @return 结果
     */
    @Override
    public int deletePollOptionByOptionIds(Long[] optionIds)
    {
        return pollOptionMapper.deletePollOptionByOptionIds(optionIds);
    }

    /**
     * 删除poll option信息
     * 
     * @param optionId poll option主键
     * @return 结果
     */
    @Override
    public int deletePollOptionByOptionId(Long optionId)
    {
        return pollOptionMapper.deletePollOptionByOptionId(optionId);
    }
}
