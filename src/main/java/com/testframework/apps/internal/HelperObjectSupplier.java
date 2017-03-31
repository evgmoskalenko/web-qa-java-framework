package com.testframework.apps.internal;

import com.testframework.apps.helpers.*;
import com.testframework.apps.wrappers.BaseHelper;

import static com.testframework.apps.internal.GenericHelper.getHelperObject;
import static com.testframework.apps.internal.HelperObjectSupplier.HelperObject.*;

public interface HelperObjectSupplier<T extends HelperObjectSupplier<T>> {

    enum HelperObject implements GenericHelper {

        NAV_HELPER {
            public BaseHelper create() {
                return new NavHelper();
            }
        }

    }

    default NavHelper navHelper() {
        return (NavHelper) getHelperObject(NAV_HELPER);
    }

}
