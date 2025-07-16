package com.ruoyi.school.service;

import java.util.List;
import com.ruoyi.school.domain.PollOption;

/**
 * poll optionService接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface IPollOptionService 
{
    /**
     * 查询poll option
     * 
     * @param optionId poll option主键
     * @return poll option
     */
    public PollOption selectPollOptionByOptionId(Long optionId);

    /**
     * 查询poll option列表
     * 
     * @param pollOption poll option
     * @return poll option集合
     */
    public List<PollOption> selectPollOptionList(PollOption pollOption);

    /**
     * 新增poll option
     * 
     * @param pollOption poll option
     * @return 结果
     */
    public int insertPollOption(PollOption pollOption);

    /**
     * 修改poll option
     * 
     * @param pollOption poll option
     * @return 结果
     */
    public int updatePollOption(PollOption pollOption);

    /**
     * 批量删除poll option
     * 
     * @param optionIds 需要删除的poll option主键集合
     * @return 结果
     */
    public int deletePollOptionByOptionIds(Long[] optionIds);

    /**
     * 删除poll option信息
     * 
     * @param optionId poll option主键
     * @return 结果
     */
    public int deletePollOptionByOptionId(Long optionId);
}
