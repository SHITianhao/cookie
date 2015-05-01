package fr.unice.polytech.tcf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by SHI Tianhao on 22/03/15.
 */
@Entity
@Table(name = "BOUTIQUES")
public class Boutique implements Serializable{
    private static final long serialVersionUID = 1L;
    private Calendar horaireOpen, horaireClose;
    private double taxe = 0.19;
    private Long id;
    private String endroit;
    private List<Commande> commandes;

    public Boutique(){
        commandes = new ArrayList<Commande>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "ENDROIT")
    public String getEndroit(){return this.endroit; }
    public void setEndroit(String endroit){ this.endroit = endroit;}

    @Column(name = "HORAIRE_OPEN")
    public Calendar getHoraireOpen(){
        return this.horaireOpen;
    }
    public void setHoraireOpen(Calendar horaire){
        this.horaireOpen = horaire;
    }

    @Column(name = "HORAIRE_CLOSE")
    public Calendar getHoraireClose(){
        return this.horaireClose;
    }
    public void setHoraireClose(Calendar horaire){
        this.horaireClose = horaire;
    }

    @Column(name = "TAXE")
    public double getTaxe(){
        return this.taxe;
    }
    public void setTaxe(double taxe){
        this.taxe = taxe;
    }


    @OneToMany(mappedBy = "boutique",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy(value = "id ASC")
    public List<Commande> getCommandes(){
        return this.commandes;
    }
    public void setCommandes(List<Commande> cs){
        this.commandes = cs;
    }
//    public void addCommande(Commande commande){
//        if (this.commandes == null){
//            this.commandes = new ArrayList<Commande>();
//        }
//        this.commandes.add(commande);
//    }
//    public int nbCommande(){
//        if (this.commandes == null)
//            return 0;
//        return this.commandes.size();
//    }

    public boolean validerRDV(Commande commande){
        Calendar rdv = commande.getRDV();
        if (rdv.after(getHoraireOpen()) && rdv.before(getHoraireClose())){
            return true;
        }
        return false;
    }

    public String toString(){
        return this.getEndroit();
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Boutique boutique = (Boutique) o;
//
//        if (Double.compare(boutique.getTaxe(), getTaxe()) != 0) return false;
//       // if (getCommandes() != null ? !getCommandes().equals(boutique.getCommandes()) : boutique.getCommandes() != null) return false;
//        if (getEndroit() != null ? !getEndroit().equals(boutique.getEndroit()) : boutique.getEndroit() != null) return false;
//        if (getHoraireClose() != null ? !getHoraireClose().equals(boutique.getHoraireClose()) : boutique.getHoraireClose() != null)
//            return false;
//        if (getHoraireOpen()!= null ? !getHoraireOpen().equals(boutique.getHoraireOpen()) : boutique.getHoraireOpen() != null) if(getId() != null ? !getId().equals(boutique.getId()) : boutique.getId() != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result;
//        long temp;
//        result = getHoraireOpen() != null ? getHoraireOpen().hashCode() : 0;
//        result = 31 * result + (getHoraireClose() != null ? getHoraireClose().hashCode() : 0);
//        temp = Double.doubleToLongBits(getTaxe());
//        result = 31 * result + (int) (temp ^ (temp >>> 32));
//        result = 31 * result + (getId()!= null ? getId().hashCode() : 0);
//        result = 31 * result + (getEndroit() != null ? getEndroit().hashCode() : 0);
//        // result = 31 * result + (getCommandes() != null ? getCommandes().hashCode() : 0);
//        return result;
//    }
}
