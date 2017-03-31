package com.testframework.apps.internal;

import com.testframework.apps.wrappers.BaseHelper;

import static com.testframework.apps.wrappers.BaseTest.getHelpers;

public interface GenericHelper {

    static BaseHelper getHelperObject(final GenericHelper helper) {
        getHelpers().putIfAbsent(helper, helper.create());
        return getHelpers().get(helper);
    }

    BaseHelper create();

}
