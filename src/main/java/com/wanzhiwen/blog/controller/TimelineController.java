package com.wanzhiwen.blog.controller;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.entity.Timeline;
import com.wanzhiwen.blog.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */

@RestController
public class TimelineController {

    @Autowired
    TimelineService timelineService;



    @PostMapping("/addTimeline")
    Response addTimeline(HttpServletRequest request, @RequestBody Timeline timeline) {
        Response response;
        response = timelineService.addTimeline(request, timeline);
        return response;
    }

    @GetMapping("/getTimelineByPage")
    Response getTimelineByPage(HttpServletRequest request){
        Response response;
        response=timelineService.getTimelineByStart(request);
        return  response;
    }

}
