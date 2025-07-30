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
import com.ruoyi.school.domain.Merchandise;
import com.ruoyi.school.service.IMerchandiseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * schoolController
 * 
 * @author ruoyi
 * @date 2025-07-25
 */
@RestController
@RequestMapping("/api/school/merchandise")
public class MerchandiseController extends BaseController
{
    @Autowired
    private IMerchandiseService merchandiseService;

    /**
     * 查询school列表
     */

    @PostMapping("/list")
    public TableDataInfo list(Merchandise merchandise)
    {
        startPage();
        List<Merchandise> list = merchandiseService.selectMerchandiseList(merchandise);
        return getDataTable(list);
    }

    /**
     * 导出school列表
     */
    @PreAuthorize("@ss.hasPermi('school:merchandise:export')")
    @Log(title = "school", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Merchandise merchandise)
    {
        List<Merchandise> list = merchandiseService.selectMerchandiseList(merchandise);
        ExcelUtil<Merchandise> util = new ExcelUtil<Merchandise>(Merchandise.class);
        util.exportExcel(response, list, "school数据");
    }

    /**
     * 获取school详细信息
     */

    @GetMapping(value = "/{merchandiseId}")
    public AjaxResult getInfo(@PathVariable("merchandiseId") Long merchandiseId)
    {
        return success(merchandiseService.selectMerchandiseByMerchandiseId(merchandiseId));
    }

    /**
     * 新增school
     */

    @Log(title = "school", businessType = BusinessType.INSERT)
    @PostMapping(value = "/add")
    public AjaxResult add(@RequestBody Merchandise merchandise)
    {
        return toAjax(merchandiseService.insertMerchandise(merchandise));
    }

    /**
     * 修改school
     */
    @PreAuthorize("@ss.hasPermi('school:merchandise:edit')")
    @Log(title = "school", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Merchandise merchandise)
    {
        return toAjax(merchandiseService.updateMerchandise(merchandise));
    }

    /**
     * 删除school
     */
    @PreAuthorize("@ss.hasPermi('school:merchandise:remove')")
    @Log(title = "school", businessType = BusinessType.DELETE)
	@DeleteMapping("/{merchandiseIds}")
    public AjaxResult remove(@PathVariable Long[] merchandiseIds)
    {
        return toAjax(merchandiseService.deleteMerchandiseByMerchandiseIds(merchandiseIds));
    }
}
