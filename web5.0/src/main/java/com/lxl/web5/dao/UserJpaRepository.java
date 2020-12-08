package com.lxl.web5.dao;

import com.lxl.web5.data.MessageInfor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserJpaRepository extends JpaRepository<MessageInfor, Long> {
    @Transactional                                       // 数据库中所有删除操作方法都必须用这个注解
    void deleteByContactname(String cname);              // 通过联系人名称删除目标数据项（这一类方法可以通过命名来指定检索条件）
    List<MessageInfor> findByContactname(String cname);  // 通过联系人名称查找目标数据项 (具体命名规则可以百度)
}
