package com.lxl.web5.service;

import com.lxl.web5.data.MessageInfor;
import com.lxl.web5.data.Table;
import java.util.List;
import java.util.Vector;

public class Tablealter {
    // 判断一个用户信息是否可以被增加
    public static boolean checkValidAdd(Table table, MessageInfor infor) {
        boolean isvalid = true;
        Vector<MessageInfor> list = table.getTableinfo();
        for (int i = 0; i < list.size() && isvalid; i++) {
            if (list.elementAt(i).getContactname().equals(infor.getContactname()))
                isvalid = false;
        }
        return isvalid;
    }

    // 更新指定元素
    public static boolean alterElem(Table table, MessageInfor infor) {
        int index = -1;
        Vector<MessageInfor> list = table.getTableinfo();
        for (int i = 0; i < list.size() && -1 == index; i++) {
            if (list.elementAt(i).getContactname().equals(infor.getContactname()))
                index = i;
        }

        if (index != -1) { //如果找到了 就替换该元素
            list.set(index, infor);
            return true;
        } else {
            return false;
        }
    }

    // 判断是否有重复的电话号码
    public static boolean hasTel(List<MessageInfor> info, String tel) {
        boolean hasTel = false;
        for (int i = 0; i < info.size() && !hasTel; i++) {
            if (info.get(i).getTel().equals(tel))
                hasTel = true;
        }
        return hasTel;
    }
}
