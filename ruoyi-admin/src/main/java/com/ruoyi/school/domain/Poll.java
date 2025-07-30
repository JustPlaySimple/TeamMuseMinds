package com.ruoyi.school.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * poll对象 poll
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public class Poll extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long pollId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String title;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String description;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long creatorId;

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    private String creatorName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isMultiple;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long maxChoices;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date startTime;

    private List<PollOption> options; // 添加这一行

    private boolean userVoted;


    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date endTime;

    public void setPollId(Long pollId) 
    {
        this.pollId = pollId;
    }

    public Long getPollId() 
    {
        return pollId;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setCreatorId(Long creatorId) 
    {
        this.creatorId = creatorId;
    }

    public Long getCreatorId() 
    {
        return creatorId;
    }

    public void setCreatorName(String creatorName)
    {
        this.creatorName = creatorName;
    }

    public String getCreatorName()
    {
        return creatorName;
    }



    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }



    public void setIsMultiple(Integer isMultiple) 
    {
        this.isMultiple = isMultiple;
    }

    public Integer getIsMultiple() 
    {
        return isMultiple;
    }

    public void setMaxChoices(Long maxChoices) 
    {
        this.maxChoices = maxChoices;
    }

    public Long getMaxChoices() 
    {
        return maxChoices;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setOptions(List<PollOption> options) {
        this.options = options;
    }

    public List<PollOption> getOptions() {
        return options;
    }

    public void setUserVoted(boolean userVoted) {
        this.userVoted = userVoted;
    }

    public boolean getUserVoted() {
        return userVoted;
    }


    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pollId", getPollId())
            .append("title", getTitle())
            .append("description", getDescription())
            .append("creatorId", getCreatorId())
            .append("isMultiple", getIsMultiple())
            .append("maxChoices", getMaxChoices())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
