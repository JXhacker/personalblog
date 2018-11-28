package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Timeline;
import com.wanzhiwen.blog.service.TimelineService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */

@RestController
public class TimelineController {

    @Autowired
    TimelineService timelineService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping("/addTimeline")
    Response addTimeline(HttpServletRequest request, @RequestBody Timeline timeline) {
        Response response;
        logger.info("addTimeline接口被调用");
        response = timelineService.addTimeline(request, timeline);
        return response;
    }

    @RequestMapping("/getTimelineByPage")
    Response getTimelineByPage(HttpServletRequest request){
        Response response;
        logger.info("getTimelineByPage接口被调用");
        response=timelineService.getTimelineByStart(request);
        return  response;
    }

}
