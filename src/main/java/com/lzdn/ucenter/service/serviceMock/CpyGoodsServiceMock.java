package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.service.CpyGoodsService;
import com.lzdn.ucenter.dao.mapper.CpyGoodsMapper;
import com.lzdn.ucenter.dao.model.CpyGoods;
import com.lzdn.ucenter.dao.model.CpyGoodsExample;

/**
* 降级实现CpyGoodsService接口
* Created by shuzheng on 2018/7/5.
*/
public class CpyGoodsServiceMock extends BaseServiceMock<CpyGoodsMapper, CpyGoods, CpyGoodsExample> implements CpyGoodsService {

}
