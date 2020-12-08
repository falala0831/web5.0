package com.lxl.web5.data;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

// 对于添加联系人 前端会先检查数据格式（JS） 然后服务器只需要检查是不是重名就行了
@Data
@Entity
@Table(name="message")
public class MessageInfor implements Serializable{
    @Id
    @Column(name = "Cname", length = 40)              // 指定持久化时该变量对应table中的字段名（可以不指定，则和变量名一致）
    private String contactname;                       // 联系人姓名

    @Column(name = "tel")                             // 同上 ，下同
    private String tel;                               // 联系人电话

    @Column(name = "email")
    private String email;                             // 邮箱

    @Column(name = "addr")
    private String addr;                              // 住址

    @Column(name = "qq")
    private String qq;                                // qq号

    @Transient                                        // 该注解说明 该成员变量不需要被持久化，仅仅当成普通java类的普通数据成员看待
    private String message;                           // 提示消息

    public MessageInfor(String cont, String tel, String email, String addr, String qq, String message) {
        this.contactname = cont;
        this.tel = tel;
        this.email = email;
        this.qq = qq;
        this.addr = addr;
        this.message = message;
    }

    public MessageInfor() {                           // 对于 Entity 实体类，必须存在默认构造函数
        this.contactname = "";
        this.tel = "";
        this.email = "";
        this.qq = "";
        this.addr = "";
        this.message = null;
    }


}
