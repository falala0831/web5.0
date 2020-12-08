package com.lxl.web5.service;

import java.util.List;
import java.util.Vector;

public class Typechange {
    // 列表转数组向量
    public static<E> Vector<E> listToVector(List<E> list) {
        return new Vector<>(list);
    }
}
