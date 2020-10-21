package com.yangshu.elastic.service;

import com.yangshu.elastic.entity.Seller;
import com.yangshu.elastic.exception.BusinessException;

import java.util.List;

/**
 * @author yangshu on 2020/10/19 20:14
 * Description：
 */
public interface SellerService {

    /**
     * 创建商家
     * @param seller
     * @return
     */
    Seller createSeller(Seller seller);

    /**
     * 通过商户id查询商家
     * @param id
     * @return
     */
    Seller findSellerById(Integer id);

    /**
     * 查询所有的商户
     * @return
     */
    List<Seller> selectAllSeller();

    /**
     * 改变商家的状态
     * @param id
     * @param disabledFlag
     * @return
     * @throws BusinessException
     */
    Seller updateSellerStatus(Integer id,Integer disabledFlag) throws BusinessException;

}
