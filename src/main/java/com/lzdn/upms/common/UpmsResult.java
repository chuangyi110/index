package com.lzdn.upms.common;

import com.lzdn.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * @author realMess
 */
public class UpmsResult extends BaseResult {

    public UpmsResult(UpmsResultConstant upmsResultConstant, Object data) {
        super(upmsResultConstant.getCode(), upmsResultConstant.getMessage(), data);
    }

}
