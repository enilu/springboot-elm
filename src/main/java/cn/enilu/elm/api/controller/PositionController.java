package cn.enilu.elm.api.controller;

import cn.enilu.elm.api.repository.BaseDao;
import cn.enilu.elm.api.service.PositionService;
import cn.enilu.elm.api.vo.CityInfo;
import cn.enilu.elm.api.vo.Rets;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created  on 2017/12/29 0029.
 *
 * @author zt
 */
@Controller
@RequestMapping
public class PositionController extends BaseController {
    @Autowired
    private BaseDao baseDao;
    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/v1/cities",method = RequestMethod.GET)
    @ResponseBody
    public Object getCityInfo(@RequestParam("type") String type, HttpServletRequest request) {
        CityInfo cityInfo = positionService.getPostion(getIp(request));
        String city = cityInfo.getCity();
        if (Strings.isNullOrEmpty(city)) {
            return Rets.failure();
        }
        return positionService.findByName(city);

    }
    @RequestMapping(value = "/v1/pois",method = RequestMethod.GET)
    @ResponseBody
    public Object getPois(@RequestParam("type")String type,
                       @RequestParam("city_id")Integer cityId,
                       @RequestParam("keyword")String keyword){

        Map map =   positionService.findById(cityId);
        return positionService.searchPlace(map.get("name").toString(),keyword);
    }

}
