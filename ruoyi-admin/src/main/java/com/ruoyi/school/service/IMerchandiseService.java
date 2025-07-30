package com.ruoyi.school.service;

import java.util.List;
import com.ruoyi.school.domain.Merchandise;

/**
 * schoolService接口
 * 
 * @author ruoyi
 * @date 2025-07-25
 */
public interface IMerchandiseService 
{
    /**
     * 查询school
     * 
     * @param merchandiseId school主键
     * @return school
     */
    public Merchandise selectMerchandiseByMerchandiseId(Long merchandiseId);

    /**
     * 查询school列表
     * 
     * @param merchandise school
     * @return school集合
     */
    public List<Merchandise> selectMerchandiseList(Merchandise merchandise);

    /**
     * 新增school
     * 
     * @param merchandise school
     * @return 结果
     */
    public int insertMerchandise(Merchandise merchandise);

    /**
     * 修改school
     * 
     * @param merchandise school
     * @return 结果
     */
    public int updateMerchandise(Merchandise merchandise);

    /**
     * 批量删除school
     * 
     * @param merchandiseIds 需要删除的school主键集合
     * @return 结果
     */
    public int deleteMerchandiseByMerchandiseIds(Long[] merchandiseIds);

    /**
     * 删除school信息
     * 
     * @param merchandiseId school主键
     * @return 结果
     */
    public int deleteMerchandiseByMerchandiseId(Long merchandiseId);
}
