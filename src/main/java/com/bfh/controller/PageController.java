package com.bfh.controller;

import com.bfh.service.MusicService;
import com.bfh.vo.MusicTopVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author wcc
 * @Time 2019/09/24
 * @Description: 用户页面跳转Controller
 */

@Controller
public class PageController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private MusicService musicService;
    @Autowired
    private RedisTemplate<String, List<MusicTopVo>> redisTemplate;

    /**
     * 跳转到歌曲搜索结果界面
     */
    @RequestMapping("/searchResult")
    public String searchResult() {
        return "music/searchResult";
    }

    /**
     * 跳转到用户详情界面
     */
    @RequestMapping("/user/profile")
    public String userProfile() {
        return "user/profile";
    }

    /**
     * 跳转到注册界面
     */
    @RequestMapping("/user/register")
    public String userRegister() {
        return "register";
    }

    /**
     * 跳转到登陆界面
     */
    @RequestMapping("/user/login")
    public String userLogin() {
        return "login";
    }


    /**
     * 跳转到404界面
     */
    @RequestMapping("/404")
    public String errorUI() {
        return "404";
    }

    /**
     * 测试：iframe化播放器
     */
    @RequestMapping("/music")
    public String music() {
        return "music";
    }

    /**
     * 跳转到内容页
     */
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    /**
     * 跳转到首页
     */
    @RequestMapping({"/", "/index"})
    public String index(HttpSession session) {


        List<MusicTopVo> likeTopsOfRedis = redisTemplate.opsForValue().get("likeTops");
        if (likeTopsOfRedis == null) {
            List<MusicTopVo> likeTop = musicService.getLikeTop();
            redisTemplate.opsForValue().set("likeTops", likeTop);
            session.setAttribute("likeTops", likeTop);
            logger.info("通过数据库");
        } else {
            session.setAttribute("likeTops", likeTopsOfRedis);
            logger.info("通过redis");
        }


        List<MusicTopVo> uploadTopsOfRedis = redisTemplate.opsForValue().get("uploadTops");
        if (uploadTopsOfRedis == null) {
            List<MusicTopVo> uploadTops = musicService.getUploadTop();
            redisTemplate.opsForValue().set("uploadTops", uploadTops);
            session.setAttribute("uploadTops", uploadTops);
        } else {
            session.setAttribute("uploadTops", uploadTopsOfRedis);
        }


        List<MusicTopVo> clickRateTopsOfRedis = redisTemplate.opsForValue().get("clickRateTops");
        if (clickRateTopsOfRedis == null) {
            List<MusicTopVo> clickRateTops = musicService.getClickRateTop();
            redisTemplate.opsForValue().set("clickRateTops", clickRateTops);
            session.setAttribute("clickRateTops", clickRateTops);
        } else {
            session.setAttribute("clickRateTops", uploadTopsOfRedis);
        }

        return "index";
    }
}
