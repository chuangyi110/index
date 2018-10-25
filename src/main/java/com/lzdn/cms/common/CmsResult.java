package com.lzdn.cms.common;

import com.lzdn.common.base.BaseResult;

public class CmsResult extends BaseResult {

    public CmsResult(CmsResultConstant cmsResultConstant, Object data) {
        super(cmsResultConstant.getCode(), cmsResultConstant.getMessage(), data);
    }
}
