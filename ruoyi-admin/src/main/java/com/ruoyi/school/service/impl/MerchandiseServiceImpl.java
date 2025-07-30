package com.ruoyi.school.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.school.mapper.MerchandiseMapper;
import com.ruoyi.school.domain.Merchandise;
import com.ruoyi.school.service.IMerchandiseService;

/**
 * schoolService业务层处理
 * 
 * @author ruoyi
 * @date 2025-07-25
 */
@Service
public class MerchandiseServiceImpl implements IMerchandiseService 
{
    @Autowired
    private MerchandiseMapper merchandiseMapper;

    /**
     * 查询school
     * 
     * @param merchandiseId school主键
     * @return school
     */
    @Override
    public Merchandise selectMerchandiseByMerchandiseId(Long merchandiseId)
    {
        return merchandiseMapper.selectMerchandiseByMerchandiseId(merchandiseId);
    }

    /**
     * 查询school列表
     * 
     * @param merchandise school
     * @return school
     */
    @Override
    public List<Merchandise> selectMerchandiseList(Merchandise merchandise)
    {
        return merchandiseMapper.selectMerchandiseList(merchandise);
    }

    /**
     * 新增school
     * 
     * @param merchandise school
     * @return 结果
     */
    @Override
    public int insertMerchandise(Merchandise merchandise)
    {
        return merchandiseMapper.insertMerchandise(merchandise);
    }

    /**
     * 修改school
     * 
     * @param merchandise school
     * @return 结果
     */
    @Override
    public int updateMerchandise(Merchandise merchandise)
    {
        return merchandiseMapper.updateMerchandise(merchandise);
    }

    /**
     * 批量删除school
     * 
     * @param merchandiseIds 需要删除的school主键
     * @return 结果
     */
    @Override
    public int deleteMerchandiseByMerchandiseIds(Long[] merchandiseIds)
    {
        return merchandiseMapper.deleteMerchandiseByMerchandiseIds(merchandiseIds);
    }

    /**
     * 删除school信息
     * 
     * @param merchandiseId school主键
     * @return 结果
     */
    @Override
    public int deleteMerchandiseByMerchandiseId(Long merchandiseId)
    {
        return merchandiseMapper.deleteMerchandiseByMerchandiseId(merchandiseId);
    }
}
