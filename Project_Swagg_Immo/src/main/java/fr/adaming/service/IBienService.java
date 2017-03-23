package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Bien;

public interface IBienService<T extends Bien> {
	
	public void addBien(T bien);
	public List<? extends Bien> findAllBien();
	public void deleteBien(int id);
	public void updateBien(T bien);
	public Bien getByIdBien(int id);
}