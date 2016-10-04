package despina.market.orm.entities;

import javax.persistence.*;

/**
 * Created by ASUS on 9/6/2016.
 */
@Entity
@javax.persistence.Table(name = "item_tbl", schema = "", catalog = "market_db")
public class ItemEntity {
    private int id;
    private String picture;
    private String title;
    private int price;
    private Integer discount;
    private Integer priceAfterDiscount;
    private Integer positiveVote;
    private Integer negativeVote;

    private void init() {
        this.picture = "default.png";
        this.discount = 2;
        this.positiveVote = 2;
        this.negativeVote = 2;
    }

    public ItemEntity() {
        init();
    }

    public ItemEntity(String title, int price) {
        this();
        this.title = title;
        this.price = price;
        this.priceAfterDiscount = (int)(price * 0.98f);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "picture", nullable = true, insertable = true, updatable = true, length = 255)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "discount", nullable = true, insertable = true, updatable = true, columnDefinition = "int DEFAULT 2")
    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    @Basic
    @Column(name = "price_after_discount", nullable = false, insertable = true, updatable = true)
    public int getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public void setPriceAfterDiscount(int priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    @Basic
    @Column(name = "positive_vote", nullable = false, insertable = true, updatable = true)
    public int getPositiveVote() {
        return positiveVote;
    }

    public void setPositiveVote(int positiveVote) {
        this.positiveVote = positiveVote;
    }

    @Basic
    @Column(name = "negative_vote", nullable = false, insertable = true, updatable = true)
    public int getNegativeVote() {
        return negativeVote;
    }

    public void setNegativeVote(int negativeVote) {
        this.negativeVote = negativeVote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemEntity that = (ItemEntity) o;

        if (id != that.id) return false;
        if (price != that.price) return false;
        if (discount != that.discount) return false;
        if (priceAfterDiscount != that.priceAfterDiscount) return false;
        if (positiveVote != that.positiveVote) return false;
        if (negativeVote != that.negativeVote) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + discount;
        result = 31 * result + priceAfterDiscount;
        result = 31 * result + positiveVote;
        result = 31 * result + negativeVote;
        return result;
    }
}
