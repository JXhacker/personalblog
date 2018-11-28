package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Timeline;
import com.wanzhiwen.blog.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */

@RestController
public class TimelineController {

    @Autowired
    TimelineService timelineService;


    @RequestMapping("/addTimeline")
    Response addTimeline(HttpServletRequest request, @RequestBody Timeline timeline) {
        Response response;
        response = timelineService.addTimeline(request, timeline);
        return response;
    }

    @RequestMapping("/getTimelineByPage")
    Response getTimelineByPage(HttpServletRequest request){
        Response response;
        response=timelineService.getTimelineByStart(request);
        return  response;
    }

}
