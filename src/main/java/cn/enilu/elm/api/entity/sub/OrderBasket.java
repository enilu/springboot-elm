package cn.enilu.elm.api.entity.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  on 2018/1/5 0005.
 *
 * @author zt
 */
public class OrderBasket {

    private List<OrderFee> abandoned_extra = new ArrayList<OrderFee>();
    private OrderFee deliver_fee = new OrderFee();
    private OrderFee packing_fee = new OrderFee();
    private List extra = new ArrayList();
    private List pindan_map = new ArrayList();
    private List<OrderGroup> group = new ArrayList<OrderGroup>();

}
