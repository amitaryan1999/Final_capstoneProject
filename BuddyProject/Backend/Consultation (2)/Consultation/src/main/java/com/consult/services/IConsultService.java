package com.consult.services;

import java.util.List;

import com.consult.model.Consult;

public interface IConsultService {

	public Consult addCon (Consult consult);
	
	public Consult updateCon (Consult consult,String consultId );
	
	public Consult getConById(String consultId);
	
	public List<Consult> getAllCons();
	
	public boolean delCOn(String consultId);
	
}
