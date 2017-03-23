package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Bien;

public interface IBienDao {

	public Bien addBien(Bien b);
	public List<Bien> findAllBiens();
	public Bien getByIdBien(int id_b);
	public Bien updateBien(Bien b);
	public void deleteBien(Bien b);
}
