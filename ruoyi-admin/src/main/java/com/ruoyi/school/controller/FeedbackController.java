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
import com.ruoyi.school.domain.Feedback;
import com.ruoyi.school.service.IFeedbackService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * submit feedbackController
 * 
 * @author ruoyi
 * @date 2025-07-07
 */
@RestController
@RequestMapping("/api/school/feedback")
public class FeedbackController extends BaseController
{
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 查询submit feedback列表
     */

    @PostMapping("/list")
    public TableDataInfo list(Feedback feedback)
    {
        startPage();
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }

    /**
     * 导出submit feedback列表
     */
    @Log(title = "submit feedback", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Feedback feedback)
    {
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        ExcelUtil<Feedback> util = new ExcelUtil<Feedback>(Feedback.class);
        util.exportExcel(response, list, "submit feedback数据");
    }

    /**
     * 获取submit feedback详细信息
     */
    @PostMapping(value = "/{feedbackId}")
    public AjaxResult getInfo(@PathVariable("feedbackId") Long feedbackId)
    {
        return success(feedbackService.selectFeedbackByFeedbackId(feedbackId));
    }

    /**
     * 新增submit feedback
     */
    @Log(title = "submit feedback", businessType = BusinessType.INSERT)
    @PostMapping

    public AjaxResult add(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.insertFeedback(feedback));
    }

    /**
     * 修改submit feedback
     */
    @Log(title = "submit feedback", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除submit feedback
     */
    @Log(title = "submit feedback", businessType = BusinessType.DELETE)
	@DeleteMapping("/{feedbackIds}")
    public AjaxResult remove(@PathVariable Long[] feedbackIds)
    {
        return toAjax(feedbackService.deleteFeedbackByFeedbackIds(feedbackIds));
    }
}
