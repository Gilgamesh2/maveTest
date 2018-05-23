package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserMapper {
    /**
     *
     * @param no
     * @return 根据ID查找User
     */
    @Select("select no,name,age from usertable where no=#{id}")
    User findById(Integer no);

    /**
     *
     * @param user
     * @return 插入一个User
     */
    @Insert("insert into usertable(name,age) values(#{name},#{age})")
    int insertUser(User user);

    /**
     *
     * @param i
     * @return 根据传入的i进行分页查寻User
     */
    @Select("select no,name,age from usertable limit #{i},#{i+10};")
    List<User> findAll(int i);
}
