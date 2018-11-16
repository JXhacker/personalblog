package com.wanzhiwen.blog.dao;

import com.wanzhiwen.blog.entity.Carousel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wanzhiwen
 * @time 2018/11/15
 */

@Repository
public interface ImgDao {
    void addImg(@Param("location") String location, @Param("ownerName") String ownerName);

    void updateCarousel(@Param("placeId") int placeId, @Param("location") String location);

    List<Carousel> getCarousels();
}
