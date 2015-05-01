package fr.unice.polytech.tcf.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    private List<Commande> commande;
    private List<Ingredient> ingredients;
    public Cookie(){
        ingredients = new ArrayList<Ingredient>();
    }

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
    @NotNull
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

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    public List<Ingredient> getIngredients() { return ingredients; }
    public void setIngredients(List<Ingredient> i) {
        this.ingredients = i;

        //calcule price
        double price = 0;
        if (this.ingredients != null){
            for (Ingredient ing : this.ingredients){
                price += ing.getPrice();
            }
            setTotalHT(price);
        }
    }
//    public void addIngredient(Ingredient i) {
//        if (this.ingredients == null){
//            this.ingredients = new ArrayList<Ingredient>();
//        }
//        this.ingredients.add(i);
//        setTotalHT(getTotalHT()+i.getPrice());
//    }
//    public int nbIngredient(){
//        if (ingredients == null)
//            return 0;
//        return ingredients.size();
//    }

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public List<Commande> getCommande(){return commande;}
    public void setCommande(List<Commande> c) {this.commande = c;}



//    public void removeIngredient(Ingredient i2) {
//        Set<Ingredient> ing = getIngredients();
//        ing.remove(i2);
//        setIngredients(ing);
//        //ingredients.remove(i2);
//    }
//

//


    public String toString() {
        List<Ingredient> ing = this.getIngredients();
        String toSend= this.getName()+":\n"+"ingredients:\n";
        for (Ingredient i:ing)
        {
            toSend += "\t"+i.getName() +"\n";
        }

        return toSend;
    }


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
