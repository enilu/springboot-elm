package cn.enilu.elm.api.controller;

import cn.enilu.elm.api.entity.Address;
import cn.enilu.elm.api.repository.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created  on 2018/1/5 0005.
 *
 * @author zt
 */
@RestController
public class AddressController extends BaseController{
    @Autowired
    private BaseDao baseDao;
    @RequestMapping(value = "/v1/users/${user_id}/addresses",method = RequestMethod.GET)
    public Object address(@PathVariable("user_id")Long userId){
        return baseDao.findAll(Address.class,"user_id",userId);
    }
}
