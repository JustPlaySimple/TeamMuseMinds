package com.ruoyi.school.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * poll record对象 poll_record
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public class PollRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long recordId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pollId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long optionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String ipAddress;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date voteTime;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }

    public void setPollId(Long pollId) 
    {
        this.pollId = pollId;
    }

    public Long getPollId() 
    {
        return pollId;
    }

    public void setOptionId(Long optionId) 
    {
        this.optionId = optionId;
    }

    public Long getOptionId() 
    {
        return optionId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setIpAddress(String ipAddress) 
    {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() 
    {
        return ipAddress;
    }

    public void setVoteTime(Date voteTime) 
    {
        this.voteTime = voteTime;
    }

    public Date getVoteTime() 
    {
        return voteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("recordId", getRecordId())
            .append("pollId", getPollId())
            .append("optionId", getOptionId())
            .append("userId", getUserId())
            .append("ipAddress", getIpAddress())
            .append("voteTime", getVoteTime())
            .toString();
    }
}
