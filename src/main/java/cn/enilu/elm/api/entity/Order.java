package cn.enilu.elm.api.entity;

import cn.enilu.elm.api.entity.sub.OrderBasket;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created  on 2018/1/5 0005.
 * todo 未完成
 * @author zt
 */
@Document(collection = "orders")
public class Order implements BaseEntity {
    private Double total_amount;
    private Double total_quantity;
    private Long unique_id;
    private Long user_id;
    private Long address_id;
    private Integer top_show=0;
    private OrderBasket basket = new OrderBasket();
}
