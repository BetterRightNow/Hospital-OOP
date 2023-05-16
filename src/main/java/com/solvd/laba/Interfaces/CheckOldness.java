package com.solvd.laba.Interfaces;

import java.util.Deque;
import java.util.List;

public interface CheckOldness<T, P, C> {
    void checkOld(T t, Deque<? extends P> patients, C collection);
}