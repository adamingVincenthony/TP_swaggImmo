package fr.adaming.dao;

import java.util.List;

import fr.adaming.entity.Bien;

public interface IBienDao<T extends Bien> {

	public Bien addBien(T b);
	public List<Bien> findAllBiens();
	public Bien getByIdBien(int id_b);
	public Bien updateBien(Bien b);
	public void deleteBien(T b);
}
