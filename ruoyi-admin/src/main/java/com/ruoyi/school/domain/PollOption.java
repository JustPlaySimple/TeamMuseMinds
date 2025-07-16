package com.ruoyi.school.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * poll option对象 poll_option
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
public class PollOption extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long optionId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long pollId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String optionText;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long voteCount;

    public void setOptionId(Long optionId) 
    {
        this.optionId = optionId;
    }

    public Long getOptionId() 
    {
        return optionId;
    }

    public void setPollId(Long pollId) 
    {
        this.pollId = pollId;
    }

    public Long getPollId() 
    {
        return pollId;
    }

    public void setOptionText(String optionText) 
    {
        this.optionText = optionText;
    }

    public String getOptionText() 
    {
        return optionText;
    }

    public void setVoteCount(Long voteCount) 
    {
        this.voteCount = voteCount;
    }

    public Long getVoteCount() 
    {
        return voteCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("optionId", getOptionId())
            .append("pollId", getPollId())
            .append("optionText", getOptionText())
            .append("voteCount", getVoteCount())
            .toString();
    }
}
