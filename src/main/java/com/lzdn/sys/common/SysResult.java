package com.lzdn.sys.common;

import com.lzdn.common.base.BaseResult;

/**
 * upms系统常量枚举类
 * @author realMess
 */
public class SysResult extends BaseResult {

    public SysResult(SysResultConstant sysResultConstant, Object data) {
        super(sysResultConstant.getCode(), sysResultConstant.getMessage(), data);
    }

}
