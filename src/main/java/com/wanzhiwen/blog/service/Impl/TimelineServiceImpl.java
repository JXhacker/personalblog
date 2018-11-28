package com.wanzhiwen.blog.service.Impl;

import com.wanzhiwen.blog.commons.Response;
import com.wanzhiwen.blog.dao.TimelineDao;
import com.wanzhiwen.blog.entity.Timeline;
import com.wanzhiwen.blog.service.TimelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

/**
 * @author wanzhiwen
 * @time 2018/11/28
 */

@Service
public class TimelineServiceImpl implements TimelineService {

    @Autowired
    TimelineDao timelineDao;

    public Response addTimeline(HttpServletRequest request, Timeline timeline) {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            return new Response(1, "未登录");
        }
        try {
            timelineDao.addTimeline(timeline);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response(1, "数据库错误");
        }
        return new Response(0, "添加成功");
    }

    public Response getTimelineByStart(HttpServletRequest request){
        int page,totalPages,start,totallines;
        List<Timeline> timelines;
        HashMap map=new HashMap();
        Response response=new Response();
        if (request.getParameter("page")==null){
            page=1;
        }else {
            page=Integer.parseInt(request.getParameter("page"));
        }
        start=(page-1)*10;
        try{
           totallines= timelineDao.getTimelineByStartNums();
           timelines=timelineDao.getTimelineByStart(start);
        }catch (Exception e){
            e.printStackTrace();
            return new Response(1,"数据库错误");
        }
        if (totallines%10==0){
            totalPages=totallines/10;
        }else {
            totalPages=totallines/10+1;
        }
        map.put("timelines",timelines);
        map.put("totalPages",totalPages);
        response.setStatus(0);
        response.setMsg("获取timeline成功");
        response.setBody(map);
        return response;
    }

}
