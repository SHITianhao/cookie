package fr.unice.polytech.tcf.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Created by Julien LVS on 14/03/15.
 */

@Entity
@Table(name = "COMMANDES")
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String owner;
    private double taxe=0.19;
    private double prixHT;
    private String boutique;
    private Calendar RDV;

//    private Boutique boutique;
//    private Set<Cookie> cookies =new HashSet<Cookie>();


    @Column(name="RDV")
    public Calendar getRDV(){
        return RDV;
    }
    public void setRDV(Calendar rdv){
        RDV = rdv;
    }

    @Column(name = "PRIXHT")
    public double getPrixHT() {
        return prixHT;
    }

    public void setPrixHT(double prixHT) {
        this.prixHT = prixHT;
    }


    public Commande() {
    }

    public Commande(long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(name = "OWNER")
    @NotNull
    public String getOwner() {
        return owner;
    }
    public void setOwner(String s) {this.owner = s;}


//    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    public Set<Cookie> getCookies() {
//        return cookies;
//    }
//    public void setCookies(Set<Cookie> c){ cookies = c;  }
//    public void addCookie(Cookie r){
//        Set<Cookie> hc = getCookies();
//        hc.add(r);
//        setCookies(hc);
//    }

    @Column(name = "TAXE")
    public double getTaxe() {
        return taxe;
    }
    public void setTaxe(double t) {this.taxe = t;}

    @Column(name = "BOUTIQUE")
    public String getBoutique() {
        return boutique;
    }
    public void setBoutique(String boutique) {
        this.boutique = boutique;
    }

//    public void calculatePrice()
//    {
//        for(Cookie r : getCookies()) {
//            setPrixHT(r.getTotalHT() +getPrixHT());
//        }
//    }
//
//    public String generateCommand() {
//        String toSend ="";
//        toSend+="------The Cookie Factory-------\n";
//        toSend+="Conservez l'ID de commande qui vous servira a retirer la commande\n";
//        toSend+="Commande n: " + getId()+"\n";
//        toSend+="Nom du client:"  + getOwner()+"\n";
//        toSend+="Boutique de retrait: " + getBoutique()+"\n";
//        for(Cookie r : getCookies()) {
//            toSend+= "Contenu du cookie "+r.toString()+"\n";
//
//        }
//
//        toSend+= "Prix HT :" + getPrixHT()+"\n";
//        toSend+= "Prix TTC :" +(getTaxe()+1)*getPrixHT()+"\n";
//        return toSend;
//    }







//    public String toString() {
//        return "Commande[" + this.getId() + "]";
//    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Commande commande = (Commande) o;
//
//        if (getId() != commande.getId()) return false;
//        if (Double.compare(commande.getPrixHT(), getPrixHT()) != 0) return false;
//        if (Double.compare(commande.getTaxe(), getTaxe()) != 0) return false;
//        if (getRDV() != null ? !getRDV().equals(commande.getRDV()) : commande.getRDV() != null) return false;
//        //if (getBoutique() != null ? !getBoutique().equals(commande.getBoutique()) : commande.getBoutique()!= null) return false;
//        if (getCookies() != null ? !getCookies().equals(commande.getCookies()) : commande.getCookies() != null) return false;
//        if (getOwner() != null ? !getOwner().equals(commande.getOwner()) : commande.getOwner() != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = (int) (getId()^ (getId()>>> 32));
//        result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
//        result = 31 * result + (getCookies()!= null ? getCookies().hashCode() : 0);
//        temp = Double.doubleToLongBits(getTaxe());
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        temp = Double.doubleToLongBits(getPrixHT());
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (getRDV() != null ? getRDV().hashCode() : 0);
//        return result;
//    }


}
