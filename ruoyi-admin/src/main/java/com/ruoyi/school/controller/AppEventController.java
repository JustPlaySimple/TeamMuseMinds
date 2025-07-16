package com.ruoyi.school.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.school.service.IAppEventRegService;
import java.util.stream.Collectors;
import java.util.Map;
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
import com.ruoyi.school.domain.AppEvent;
import com.ruoyi.school.service.IAppEventService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.school.domain.AppEventReg;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2025-07-06
 */
@RestController
@RequestMapping("/api/school/events")
public class AppEventController extends BaseController
{
    @Autowired
    private IAppEventService appEventService;

    @Autowired
    private IAppEventRegService appEventRegService;

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    public TableDataInfo list(AppEvent appEvent)
    {
        startPage();
        List<AppEvent> list = appEventService.selectAppEventList(appEvent);
        return getDataTable(list);
    }

    /**
     * 查询事件列表，返回是否已报名字段
     */
    @PostMapping("/listWithRegister")
    public TableDataInfo list(@RequestBody AppEvent appEvent, @RequestParam("userId") Long userId)
    {
        startPage();
        List<AppEvent> list = appEventService.selectAppEventList(appEvent);
        AppEventReg reg = new AppEventReg();
        reg.setUserId(userId);
        List<AppEventReg> regList = appEventRegService.selectAppEventRegList(reg);

        Map<Long, String> regStatusMap = regList.stream()
                .collect(Collectors.toMap(AppEventReg::getEventId, AppEventReg::getStatus));

        // 设置 joinedType（0-未报名，1-已报名，2-已加入）
        for (AppEvent event : list) {
            Long eventId = event.getEventId();
            if (regStatusMap.containsKey(eventId)) {
                String status = regStatusMap.get(eventId);
                if ("2".equals(status)) {
                    event.setJoinedType("2");
                } else {
                    event.setJoinedType("1");
                }
            } else {
                event.setJoinedType("0");
            }
        }

        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppEvent appEvent)
    {
        List<AppEvent> list = appEventService.selectAppEventList(appEvent);
        ExcelUtil<AppEvent> util = new ExcelUtil<AppEvent>(AppEvent.class);
        util.exportExcel(response, list, "【请填写功能名称】数据");
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @PostMapping(value = "/{eventId}")
    public AjaxResult getInfo(@PathVariable("eventId") Long eventId)
    {
        return success(appEventService.selectAppEventByEventId(eventId));
    }

    /**
     * 新增【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppEvent appEvent)
    {
        return toAjax(appEventService.insertAppEvent(appEvent));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(@RequestBody AppEvent appEvent)
    {
        return toAjax(appEventService.updateAppEvent(appEvent));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{eventIds}")
    public AjaxResult remove(@PathVariable Long[] eventIds)
    {
        return toAjax(appEventService.deleteAppEventByEventIds(eventIds));
    }
}
