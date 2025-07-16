package com.ruoyi.school.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 app_event
 *
 * @author ruoyi
 * @date 2025-07-06
 */
public class AppEvent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long eventId;

    /**  */
    @Excel(name = "")
    private Long createUserId;

    /**  */
    @Excel(name = "")
    private String title;

    /**  */
    @Excel(name = "")
    private String description;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**  */
    @Excel(name = "")
    private Long registerUserId;

    /** event status */
    @Excel(name = "event status")
    private Long eventStatus;

    private String joinedType;

    /** Comma-separated image URLs */
    @Excel(name = "Comma-separated image URLs")
    private String images;

    public void setEventId(Long eventId)
    {
        this.eventId = eventId;
    }

    public Long getEventId()
    {
        return eventId;
    }

    public void setCreateUserId(Long createUserId)
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId()
    {
        return createUserId;
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

    public void setJoinedType(String joinedType) {
        this.joinedType = joinedType;
    }

    public String getJoinedType()
    {
        return joinedType;
    }


    public void setRegisterUserId(Long registerUserId)
    {
        this.registerUserId = registerUserId;
    }

    public Long getRegisterUserId()
    {
        return registerUserId;
    }

    public void setEventStatus(Long eventStatus)
    {
        this.eventStatus = eventStatus;
    }

    public Long getEventStatus()
    {
        return eventStatus;
    }

    public void setImages(String images)
    {
        this.images = images;
    }

    public String getImages()
    {
        return images;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("eventId", getEventId())
                .append("createUserId", getCreateUserId())
                .append("title", getTitle())
                .append("description", getDescription())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("registerUserId", getRegisterUserId())
                .append("eventStatus", getEventStatus())
                .append("images", getImages())
                .toString();
    }
}
