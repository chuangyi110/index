package com.lzdn.ucenter.service.serviceMock;

import com.lzdn.common.base.BaseServiceMock;
import com.lzdn.ucenter.dao.model.CpyActivityExample;
import com.lzdn.ucenter.service.CpyActivityService;
import com.lzdn.ucenter.dao.mapper.CpyActivityMapper;
import com.lzdn.ucenter.dao.model.CpyActivity;

/**
* 降级实现CpyActivityService接口
* Created by shuzheng on 2018/7/5.
*/
public class CpyActivityServiceMock extends BaseServiceMock<CpyActivityMapper, CpyActivity, CpyActivityExample> implements CpyActivityService {

    @Override
    public int changeStatusById(int id) {
        return 0;
    }
}
