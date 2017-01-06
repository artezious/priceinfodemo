package web.productInfo.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by WEO on 1/4/17.
 */

@Entity
@Table (name = "Products")
public class ProductEntity {

    private int id;
    private String productname;
    private Timestamp timestamp_ex;//не надо называть колонки также как и сам тип данных
    private double price;

    public ProductEntity() {
    }

    public ProductEntity(int id, String productname, Timestamp timestamp, double price) {
        this.id = id;
        this.productname = productname;
        this.timestamp_ex = timestamp;
        this.price = price;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column (name = "productname")
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Column (name = "timestamp_ex")
    public Timestamp getTimestamp_ex() {
        return timestamp_ex;
    }

    public void setTimestamp_ex(Timestamp timestamp_ex) {
        this.timestamp_ex = timestamp_ex;
    }

    @Column (name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (productname != null ? !productname.equals(that.productname) : that.productname != null) return false;
        return timestamp_ex != null ? timestamp_ex.equals(that.timestamp_ex) : that.timestamp_ex == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (productname != null ? productname.hashCode() : 0);
        result = 31 * result + (timestamp_ex != null ? timestamp_ex.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "ProductEntity{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", timestamp_ex=" + timestamp_ex +
                ", price=" + price +
                '}';
    }
}
