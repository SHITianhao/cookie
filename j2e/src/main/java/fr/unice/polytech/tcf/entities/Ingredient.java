package fr.unice.polytech.tcf.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 14/03/15.
 */

@Entity
@Table(name = "INGREDIENTS")
public class Ingredient implements Serializable {
    private List<Cookie> cookies;

    private String name;
    private double price;
    private Long id;

    public Ingredient(){
        cookies = new ArrayList<Cookie>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId(){return this.id;}
    public void setId(Long id){this.id = id;}


    @Column(name = "name")
    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price")
    @NotNull
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToMany(mappedBy = "ingredients")//mapping by ingredients => does not work
    public List<Cookie> getCookies() { return cookies; }
    public void setCookies(List<Cookie> cookies) { this.cookies = cookies; }
//    public void addCookie(Cookie c){
//        if (this.cookies == null){
//            cookies = new ArrayList<Cookie>();
//        }
//        cookies.add(c);
//    }
//
//    public void deleteCookie(Cookie c){
//        Set<Cookie> sc = getCookies();
//        sc.remove(c);
//        setCookies(sc);
//    }




//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (!(o instanceof Ingredient)) return false;
//
//		Ingredient that = (Ingredient) o;
//
//		if (Double.compare(that.getPrice(), getPrice()) != 0) return false;
//		if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
//		if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
//
//		return true;
//	}

//	@Override
//	public int hashCode() {
//		int result;
//		long temp;
//		result = getName() != null ? getName().hashCode() : 0;
//		temp = Double.doubleToLongBits(getPrice());
//		result = 31 * result + (int) (temp ^ (temp >>> 32));
//		result = 31 * result + (getId() != null ? getId().hashCode() : 0);
//		return result;
//	}
//
//	@Override
//	public String toString() {
//		return "Ingredient{" +
//				"cookies=" + getCookies() +
//				", name='" + getName() + '\'' +
//				", price=" + getPrice() +
//				", id=" + getId() +
//				'}';
//	}


}
