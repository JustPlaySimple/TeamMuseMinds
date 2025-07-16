package com.ruoyi.school.domain;

import java.util.Date;
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

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isMultiple;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long maxChoices;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date startTime;

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
