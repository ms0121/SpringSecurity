package com.liu.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liu.security.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lms
 * @date 2021-06-21 - 10:35
 */
// 当前使用的mybatis-plus已经封装了操作数据库常用的方法，所以不需要再额外的编写xml映射文件

@Mapper
public interface UserMapper extends BaseMapper<Users> {

}
