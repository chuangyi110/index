package com.lzdn.ucenter.service;

import com.lzdn.common.base.BaseService;
import com.lzdn.ucenter.dao.model.CpyActivity;
import com.lzdn.ucenter.dao.model.CpyActivityExample;

/**
* CpyActivityService接口
* Created by realMess on 2018/7/5.
*/
public interface CpyActivityService extends BaseService<CpyActivity, CpyActivityExample> {

    int changeStatusById(int id);
}