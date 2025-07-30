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
import com.ruoyi.school.domain.PollRecord;
import com.ruoyi.school.service.IPollRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * poll recordController
 * 
 * @author ruoyi
 * @date 2025-07-16
 */
@RestController
@RequestMapping("/api/school/record")
public class PollRecordController extends BaseController
{
    @Autowired
    private IPollRecordService pollRecordService;

    /**
     * 查询poll record列表
     */

    @GetMapping("/list")
    public TableDataInfo list(PollRecord pollRecord)
    {
        startPage();
        List<PollRecord> list = pollRecordService.selectPollRecordList(pollRecord);
        return getDataTable(list);
    }

    /**
     * 导出poll record列表
     */

    @Log(title = "poll record", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PollRecord pollRecord)
    {
        List<PollRecord> list = pollRecordService.selectPollRecordList(pollRecord);
        ExcelUtil<PollRecord> util = new ExcelUtil<PollRecord>(PollRecord.class);
        util.exportExcel(response, list, "poll record数据");
    }

    /**
     * 获取poll record详细信息
     */

    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return success(pollRecordService.selectPollRecordByRecordId(recordId));
    }

    /**
     * 新增poll record
     */

    @Log(title = "poll record", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody PollRecord pollRecord)
    {
        Long userId = pollRecord.getUserId(); // 可能为 null

        // 如果传入了 userId，则检查是否已投票
        if (userId != null && pollRecord.getPollId() != null) {
            Integer count = pollRecordService.countUserVotes(pollRecord);
            if (count !=null && count > 0) {
                return AjaxResult.error("You have already voted.");
            }
        }
        return toAjax(pollRecordService.insertPollRecord(pollRecord));
    }

    /**
     * 修改poll record
     */

    @Log(title = "poll record", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PollRecord pollRecord)
    {
        return toAjax(pollRecordService.updatePollRecord(pollRecord));
    }

    /**
     * 删除poll record
     */

    @Log(title = "poll record", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(pollRecordService.deletePollRecordByRecordIds(recordIds));
    }
}
