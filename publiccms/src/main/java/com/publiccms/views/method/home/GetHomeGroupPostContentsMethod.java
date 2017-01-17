package com.publiccms.views.method.home;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.entities.home.HomeGroupPostContent;
import com.publiccms.logic.service.home.HomeGroupPostContentService;
import com.sanluan.common.base.BaseMethod;

import freemarker.template.TemplateModelException;

@Component
public class GetHomeGroupPostContentsMethod extends BaseMethod {
    /*
     * (non-Javadoc)
     * 
     * @see freemarker.template.TemplateMethodModelEx#exec(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object exec(@SuppressWarnings("rawtypes") List arguments) throws TemplateModelException {
        Long[] ids = getLongArray(0, arguments);
        if (notEmpty(ids)) {
            Map<String, String> resultMap = new HashMap<String, String>();
            for (HomeGroupPostContent entity : service.getEntitys(ids)) {
                resultMap.put(String.valueOf(entity.getPostId()), entity.getContent());
            }
            return resultMap;
        }
        return null;
    }

    @Override
    public boolean needAppToken() {
        return true;
    }

    @Override
    public int minParamtersNumber() {
        return 1;
    }

    @Autowired
    private HomeGroupPostContentService service;
}
