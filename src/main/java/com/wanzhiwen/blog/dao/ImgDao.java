package com.wanzhiwen.blog.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author wanzhiwen
 * @time 2018/11/15
 */

@Repository
public interface ImgDao {
    void addImg(@Param("location") String location,@Param("ownerName") String ownerName);
}
