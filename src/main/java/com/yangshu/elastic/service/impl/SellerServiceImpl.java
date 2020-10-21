package com.yangshu.elastic.service.impl;

import com.yangshu.elastic.entity.Seller;
import com.yangshu.elastic.enums.ResultEnum;
import com.yangshu.elastic.exception.BusinessException;
import com.yangshu.elastic.mapper.SellerMapper;
import com.yangshu.elastic.service.SellerService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author yangshu on 2020/10/19 20:19
 * Description：
 */

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerMapper sellerMapper;


    /**
     * 创建商家
     *
     * @param seller
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Seller createSeller(Seller seller) {
        seller.setRemarkScore(new BigDecimal(0));
        seller.setDisabledFlag(0);
        sellerMapper.insertSelective(seller);

        return findSellerById(seller.getId());
    }

    /**
     * 通过商户id查询商家
     *
     * @param id
     * @return
     */
    @Override
    public Seller findSellerById(Integer id) {
        return sellerMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有的商户
     *
     * @return
     */
    @Override
    public List<Seller> selectAllSeller() {
        return sellerMapper.selectAll();
    }

    /**
     * 改变商家的状态
     *
     * @param id
     * @param disabledFlag
     * @return
     * @throws BusinessException
     */
    @Override
    public Seller updateSellerStatus(Integer id, Integer disabledFlag) throws BusinessException {
        Seller seller = findSellerById(id);
        if(ObjectUtils.isEmpty(seller)) {
            throw new BusinessException(ResultEnum.SELLER_IS_NOT_EXIST);
        }
        seller.setDisabledFlag(disabledFlag);

        Example example = new Example(Seller.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("disabledFlag",disabledFlag);
        sellerMapper.updateByExampleSelective(seller,example);
        return seller;
    }
}
