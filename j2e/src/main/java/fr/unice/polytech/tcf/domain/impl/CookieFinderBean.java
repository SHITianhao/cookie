package fr.unice.polytech.tcf.domain.impl;

import fr.unice.polytech.tcf.domain.CookieFinder;
import fr.unice.polytech.tcf.entities.Cookie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sth on 13/04/15.
 */
@Stateless
public class CookieFinderBean implements CookieFinder{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Cookie findByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cookie> criteria = builder.createQuery(Cookie.class);
        Root<Cookie> from = criteria.from(Cookie.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("name"), name));
        TypedQuery<Cookie> query = entityManager.createQuery(criteria);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Cookie> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Cookie> cq = cb.createQuery(Cookie.class);
        TypedQuery<Cookie> allQuery = entityManager.createQuery(cq.select(cq.from(Cookie.class)));
        return allQuery.getResultList();
    }
}
