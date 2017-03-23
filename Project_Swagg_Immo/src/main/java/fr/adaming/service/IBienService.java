package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Bien;

public interface IBienService {
	
	public void addBien(Bien bien);
	public List<Bien> findAllBien();
	public void deleteBien(int id);
	public void updateBien(Bien bien);
	public Bien getByIdBien(int id);
}