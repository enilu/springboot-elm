package cn.enilu.elm.api.controller;

import cn.enilu.elm.api.entity.Order;
import cn.enilu.elm.api.repository.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created  on 2018/1/5 0005.
 *
 * @author zt
 */
@RestController
public class OrderController extends BaseController {
    @Autowired
    private BaseDao baseDao;
    @RequestMapping("/bos/v2/users/${user_id}/orders")
    public Object orders(@PathVariable("user_id")Long userId){
        return baseDao.findAll(Order.class,"user_id",userId);

    }
}
