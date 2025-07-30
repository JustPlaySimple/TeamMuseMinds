package com.ruoyi.school.mapper;

import java.util.List;
import com.ruoyi.school.domain.Merchandise;

/**
 * schoolMapper接口
 * 
 * @author ruoyi
 * @date 2025-07-25
 */
public interface MerchandiseMapper 
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
     * 删除school
     * 
     * @param merchandiseId school主键
     * @return 结果
     */
    public int deleteMerchandiseByMerchandiseId(Long merchandiseId);

    /**
     * 批量删除school
     * 
     * @param merchandiseId 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMerchandiseByMerchandiseIds(Long[] merchandiseIds);
}
