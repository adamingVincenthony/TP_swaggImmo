package fr.adaming.service;

import java.util.List;

import fr.adaming.entity.Bien;
import fr.adaming.entity.BienAAcheter;
import fr.adaming.entity.BienALouer;
import fr.adaming.entity.TerrainAAcheter;

public interface IBienService {
	
	public void addBienBAL(BienALouer bien);
	public void addBienBAV(BienAAcheter bien);
	public void addTerrain(TerrainAAcheter bien);
	public List<Bien> findAllBien();
	public void deleteBien(int id);
	public void updateBien(Bien bien);
	public Bien getByIdBien(int id);
}