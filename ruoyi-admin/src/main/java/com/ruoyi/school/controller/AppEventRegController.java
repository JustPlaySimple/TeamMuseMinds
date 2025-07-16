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
import com.ruoyi.school.domain.AppEventReg;
import com.ruoyi.school.service.IAppEventRegService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * userController
 * 
 * @author ruoyi
 * @date 2025-07-07
 */
@RestController
@RequestMapping("/api/school/reg")
public class AppEventRegController extends BaseController
{
    @Autowired
    private IAppEventRegService appEventRegService;

    /**
     * 查询event register列表
     */

    @PostMapping("/list")
    public TableDataInfo list(AppEventReg appEventReg)
    {
        startPage();
        List<AppEventReg> list = appEventRegService.selectAppEventRegList(appEventReg);
        return getDataTable(list);
    }

    /**
     * 导出user列表
     */

    @Log(title = "user", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppEventReg appEventReg)
    {
        List<AppEventReg> list = appEventRegService.selectAppEventRegList(appEventReg);
        ExcelUtil<AppEventReg> util = new ExcelUtil<AppEventReg>(AppEventReg.class);
        util.exportExcel(response, list, "user数据");
    }

    /**
     * 获取user详细信息
     */

    @GetMapping(value = "/{registrationId}")
    public AjaxResult getInfo(@PathVariable("registrationId") Long registrationId)
    {
        return success(appEventRegService.selectAppEventRegByRegistrationId(registrationId));
    }

    /**
     * 新增user
     */

    @Log(title = "user", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppEventReg appEventReg)
    {
        // First, check if a registration record already exists
        AppEventReg query = new AppEventReg();
        query.setEventId(appEventReg.getEventId());
        query.setUserId(appEventReg.getUserId());

        List<AppEventReg> existingList = appEventRegService.selectAppEventRegList(query);

        if (existingList != null && !existingList.isEmpty()) {
            // Record already exists, update the status field
            AppEventReg existing = existingList.get(0);
            existing.setStatus(appEventReg.getStatus()); // Update status
            return toAjax(appEventRegService.updateAppEventReg(existing));
        } else {
            // Record does not exist, insert a new one
            return toAjax(appEventRegService.insertAppEventReg(appEventReg));
        }
    }


    /**
     * 修改user
     */

    @Log(title = "user", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppEventReg appEventReg)
    {
        return toAjax(appEventRegService.updateAppEventReg(appEventReg));
    }

    /**
     * 删除user
     */
    @PreAuthorize("@ss.hasPermi('school:reg:remove')")
    @Log(title = "user", businessType = BusinessType.DELETE)
	@DeleteMapping("/{registrationIds}")
    public AjaxResult remove(@PathVariable Long[] registrationIds)
    {
        return toAjax(appEventRegService.deleteAppEventRegByRegistrationIds(registrationIds));
    }
}
