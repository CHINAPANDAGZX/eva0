package com.owalai.eva0.jpa;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //根据用户名称查询
    @Query(value =  "select * from tbl_user s where  s.name=?1",nativeQuery = true)
    public List<User> queryUserByName(String name);
}
