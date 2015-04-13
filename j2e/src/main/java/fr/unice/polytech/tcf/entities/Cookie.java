package fr.unice.polytech.tcf.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Julien LVS on 14/03/15.
 */

@Entity
@Table(name = "RECETTES")
public class Cookie implements Serializable{
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private double totalHT=0;

//    private Commande commande;
//    private Set<Ingredient> ingredients = new HashSet<Ingredient>();

    public Cookie(){}

//    //Pour une recette spéciale
//    public Cookie(String special)
//    {
//        if (special.equals("CookieTropBon")) {
//            totalHT = 10;
//            name = "CookieTropBon";
//        }
//
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id){this.id = id;}


    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}


    @Column(name = "TOTALHT")
    public double getTotalHT() {
        return totalHT;
    }
    public void setTotalHT(double tot) {
        this.totalHT = tot;
    }

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "COOK_INGR")
//    public Set<Ingredient> getIngredients() { return ingredients; }
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    public Commande getCommande(){return commande;}


//    public void addIngredient(Ingredient i) {
//        Set<Ingredient> ing = getIngredients();
//        ing.add(i);
//        setIngredients(ing);
//        setTotalHT(getTotalHT()+i.getPrice());
//    }
//    public void removeIngredient(Ingredient i2) {
//        Set<Ingredient> ing = getIngredients();
//        ing.remove(i2);
//        setIngredients(ing);
//        //ingredients.remove(i2);
//    }
//
//    public void setIngredients(Set<Ingredient> i)
//    {
//        this.ingredients = i;
//    }
//
//
//    public void setCommande(Commande c) {this.commande = c;}
//
//    public String toString() {
//        Set<Ingredient> ing = this.getIngredients();
//        String toSend="\n";
//        for (Ingredient i:ing)
//        {
//            toSend += i.getName() +"\n";
//        }
//
//        return toSend;
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Cookie cookie = (Cookie) o;
//
//        if (id != cookie.id) return false;
//        if (Double.compare(cookie.getTotalHT(), getTotalHT()) != 0) return false;
//        if (getCommande() != null ? !getCommande().equals(cookie.getCommande()) : cookie.getCommande() != null) return false;
//        if (getIngredients() != null ? !getIngredients().equals(cookie.getIngredients()) : cookie.getIngredients() != null) return false;
//        if (getName() != null ? !getName().equals(cookie.getName()) : cookie.getName() != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = (int) (getId() ^ (getId() >>> 32));
//        result = 31 * result + (getName()!= null ? getName().hashCode() : 0);
//        result = 31 * result + (getIngredients() != null ? getIngredients().hashCode() : 0);
//        temp = Double.doubleToLongBits(getTotalHT());
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        return result;
//    }
}
