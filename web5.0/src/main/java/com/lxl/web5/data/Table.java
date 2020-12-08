package com.lxl.web5.data;

import lombok.Data;

import java.io.Serializable;
import java.util.Vector;

@Data
public class Table implements Serializable {
    private Vector<MessageInfor> tableinfo;
    public Table(Vector<MessageInfor> info)
    {
        this.tableinfo = info;
    }
}
