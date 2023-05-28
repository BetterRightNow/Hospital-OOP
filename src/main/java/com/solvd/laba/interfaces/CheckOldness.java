package com.solvd.laba.interfaces;

import java.util.Deque;

public interface CheckOldness<T, P, C> {
    void checkOld(T t, Deque<? extends P> patients, C collection);
}