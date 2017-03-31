package com.testframework.apps.wrappers;

import com.testframework.apps.internal.Cookies;
import com.testframework.apps.internal.PageObjectsSupplier;

public abstract class BaseHelper<T extends BaseHelper<T>> implements PageObjectsSupplier, Cookies {
}
