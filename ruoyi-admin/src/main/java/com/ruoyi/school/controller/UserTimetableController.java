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
import org.springframework.web.bind.annotation.RequestParam;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.school.domain.UserTimetable;
import com.ruoyi.school.service.IUserTimetableService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;


/**
 * timetableController
 * 
 * @author chenc
 * @date 2025-07-30
 */
@RestController
@RequestMapping("/api/school/timetable")
public class UserTimetableController extends BaseController
{
    @Autowired
    private IUserTimetableService userTimetableService;



    /**
     * 查询timetable列表
     */
    @PostMapping("/list")
    public TableDataInfo list(UserTimetable userTimetable)
    {
        startPage();
        List<UserTimetable> list = userTimetableService.selectUserTimetableList(userTimetable);
        return getDataTable(list);
    }

    /**
     * 导出timetable列表
     */
    @PreAuthorize("@ss.hasPermi('school:timetable:export')")
    @Log(title = "timetable", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserTimetable userTimetable)
    {
        List<UserTimetable> list = userTimetableService.selectUserTimetableList(userTimetable);
        ExcelUtil<UserTimetable> util = new ExcelUtil<UserTimetable>(UserTimetable.class);
        util.exportExcel(response, list, "timetable数据");
    }

    /**
     * 获取timetable详细信息
     */
    @PreAuthorize("@ss.hasPermi('school:timetable:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userTimetableService.selectUserTimetableById(id));
    }

    /**
     * 新增timetable
     */
    @Log(title = "timetable", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult add(@RequestBody UserTimetable userTimetable)
    {
        return toAjax(userTimetableService.insertUserTimetable(userTimetable));
    }

    /**
     * 修改timetable
     */
    @PreAuthorize("@ss.hasPermi('school:timetable:edit')")
    @Log(title = "timetable", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserTimetable userTimetable)
    {
        return toAjax(userTimetableService.updateUserTimetable(userTimetable));
    }

    /**
     * 删除timetable
     */
    @PreAuthorize("@ss.hasPermi('school:timetable:remove')")
    @Log(title = "timetable", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userTimetableService.deleteUserTimetableByIds(ids));
    }


    @PostMapping("/scanImage")
    public AjaxResult scanTimetableImage(@RequestParam("file") MultipartFile file, @RequestParam Long userId) {
        try {
            List<UserTimetable> inserted = userTimetableService.scanImageAndGenerateTimetable(file, userId);
            return AjaxResult.success("识别成功，共插入：" + inserted.size() + " 条", inserted);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("OCR识别失败：" + e.getMessage());
        }
    }




}
