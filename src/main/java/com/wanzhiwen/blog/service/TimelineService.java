package com.wanzhiwen.blog.service;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Timeline;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */
public interface TimelineService {

    Response addTimeline(HttpServletRequest request, Timeline timeline);

    Response getTimelineByStart(HttpServletRequest request);
}
