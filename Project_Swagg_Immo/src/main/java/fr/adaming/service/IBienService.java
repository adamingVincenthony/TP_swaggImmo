package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienALouer;

public interface IBienService {
	
	public void addBienBAL(BienALouer bien);
	public List<Bien> findAllBien();
	public void deleteBien(int id);
	public void updateBien(Bien bien);
	public Bien getByIdBien(int id);
}