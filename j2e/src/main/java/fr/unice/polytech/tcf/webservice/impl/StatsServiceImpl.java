package fr.unice.polytech.tcf.webservice.impl;

import fr.unice.polytech.tcf.webservice.StatsService;

import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 * Created by sth on 25/04/15.
 */
@WebService(targetNamespace = "http://www.polytech.unice.fr/tcf")
@Stateless
public class StatsServiceImpl implements StatsService{
}
