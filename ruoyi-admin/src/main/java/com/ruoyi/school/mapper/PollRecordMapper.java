package com.ruoyi.school.mapper;

import java.util.List;
import com.ruoyi.school.domain.PollRecord;

/**
 * poll recordMapper接口
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public interface PollRecordMapper 
{
    /**
     * 查询poll record
     * 
     * @param recordId poll record主键
     * @return poll record
     */
    public PollRecord selectPollRecordByRecordId(Long recordId);

    /**
     * 查询poll record列表
     * 
     * @param pollRecord poll record
     * @return poll record集合
     */
    public List<PollRecord> selectPollRecordList(PollRecord pollRecord);

    /**
     * 新增poll record
     * 
     * @param pollRecord poll record
     * @return 结果
     */
    public int insertPollRecord(PollRecord pollRecord);

    /**
     * 修改poll record
     * 
     * @param pollRecord poll record
     * @return 结果
     */
    public int updatePollRecord(PollRecord pollRecord);

    /**
     * 删除poll record
     * 
     * @param recordId poll record主键
     * @return 结果
     */
    public int deletePollRecordByRecordId(Long recordId);

    /**
     * 批量删除poll record
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePollRecordByRecordIds(Long[] recordIds);
}
