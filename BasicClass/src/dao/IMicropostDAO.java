/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Micropost;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IMicropostDAO {
    public List<Micropost> all();

	public Micropost find(int id);

	public void create(Micropost micropost);

	public void update(Micropost micropost);

	public void delete(Micropost micropost);
}
