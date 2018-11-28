package com.wanzhiwen.blog.dao;

import com.wanzhiwen.blog.entity.Timeline;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */

@Repository
public interface TimelineDao {

    void addTimeline(Timeline timeline);
    List<Timeline> getTimelineByStart(int start);
    Integer getTimelineByStartNums();
}
