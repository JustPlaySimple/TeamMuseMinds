package com.ruoyi.school.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.school.domain.Poll;
import com.ruoyi.school.domain.PollOption;
import com.ruoyi.school.service.IPollService;
import com.ruoyi.school.service.IPollOptionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * pollController
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@RestController
@RequestMapping("/api/school/poll")
public class PollController extends BaseController
{
    @Autowired
    private IPollService pollService;

    @Autowired
    private IPollOptionService pollOptionService;

    /**
     * 查询poll列表
     */

    @PostMapping("/list")
    public TableDataInfo list(Poll poll)
    {
        startPage();
        List<Poll> list = pollService.selectPollList(poll);
        return getDataTable(list);
    }

    /**
     * 导出poll列表
     */

    @Log(title = "poll", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Poll poll)
    {
        List<Poll> list = pollService.selectPollList(poll);
        ExcelUtil<Poll> util = new ExcelUtil<Poll>(Poll.class);
        util.exportExcel(response, list, "poll数据");
    }

    /**
     * 获取poll详细信息
     */

    @GetMapping(value = "/{pollId}")
    public AjaxResult getInfo(@PathVariable("pollId") Long pollId)
    {
        return success(pollService.selectPollByPollId(pollId));
    }

    /**
     * 新增poll
     */

    @Log(title = "poll", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody Poll poll)
    {
        return toAjax(pollService.insertPoll(poll));
    }


    @PostMapping("/addWithOptions")
    public AjaxResult addWithOptions(@RequestBody Poll poll) {

        int result = pollService.insertPoll(poll); // 这一步之后 poll.pollId 已被自动设置（useGeneratedKeys）


        if (poll.getOptions() != null) {
            for (PollOption option : poll.getOptions()) {
                option.setPollId(poll.getPollId()); // 关键！设置 pollId
                pollOptionService.insertPollOption(option);
            }
        }
        return toAjax(result);
    }




    /**
     * 修改poll
     */

    @Log(title = "poll", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Poll poll)
    {
        return toAjax(pollService.updatePoll(poll));
    }

    /**
     * 删除poll
     */

    @Log(title = "poll", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pollIds}")
    public AjaxResult remove(@PathVariable Long[] pollIds)
    {
        return toAjax(pollService.deletePollByPollIds(pollIds));
    }
}
