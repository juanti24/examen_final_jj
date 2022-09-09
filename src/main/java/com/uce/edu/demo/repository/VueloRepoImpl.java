package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepoImpl implements IVueloRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vuelo);
	}

	@Override
	public Vuelo read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Vuelo.class, id);
	}

	@Override
	public void update(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.entityManager.merge(vuelo);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.read(id));
	}

	@Override
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fechaVuelo) {
		TypedQuery<Vuelo> myQuery=this.entityManager.createQuery("Select v from Vuelo v where v.origen=:valor1 and v.destino=:valor2 and v.fechaVuelo=:valor3", Vuelo.class);
		myQuery.setParameter("valor1", origen);
		myQuery.setParameter("valor2", destino);
		myQuery.setParameter("valor3", fechaVuelo);
		return myQuery.getResultList();
	}

	@Override
	public Vuelo buscarNumero(String numeroVuelo) {
		TypedQuery<Vuelo> myQuery=this.entityManager.createQuery("Delect v fron Vuelo v where v.numero=:valor", Vuelo.class);
		myQuery.setParameter("valor", numeroVuelo);
		return myQuery.getSingleResult();
	}
}