package cn.enilu.elm.api.controller;

import cn.enilu.elm.api.repository.BaseDao;
import cn.enilu.elm.api.vo.Rets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zt on 2017/12/12 0012.
 */
@Controller
@RequestMapping("/v1/users")
public class UserController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private BaseDao baseDao;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public Object list(@RequestParam("offset") Integer offset,@RequestParam("limit") Integer limit){
        List list = baseDao.findAll("userinfos");
        return list;
    }
    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ResponseBody
    public Object count(){
        return Rets.success("count",2);
    }

}
