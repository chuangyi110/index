package com.lzdn.ucenter.common;

import com.lzdn.common.base.BaseResult;

public class UcenterResult extends BaseResult {

    public UcenterResult(UcenterResultConstant ucenterResultConstant, Object data) {
        super(ucenterResultConstant.code,ucenterResultConstant.message,data);
    }
}
