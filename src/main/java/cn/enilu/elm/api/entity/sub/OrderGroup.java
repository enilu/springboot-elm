package cn.enilu.elm.api.entity.sub;

import java.util.List;

/**
 * Created  on 2018/1/5 0005.
 *
 * @author zt
 */
public class OrderGroup {
    private List attrs;
    private List new_specs;
    private String name;
    private Double price;
    private Double quantity;
    private String specs;

    public List getAttrs() {
        return attrs;
    }

    public void setAttrs(List attrs) {
        this.attrs = attrs;
    }

    public List getNew_specs() {
        return new_specs;
    }

    public void setNew_specs(List new_specs) {
        this.new_specs = new_specs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }
}
