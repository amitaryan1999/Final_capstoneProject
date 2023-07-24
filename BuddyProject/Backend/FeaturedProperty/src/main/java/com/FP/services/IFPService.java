package com.FP.services;

import java.util.List;

import com.FP.model.Featured;

public interface IFPService {
  
	   public Featured getFeaturedPropertyByID(String id);

	    public List<Featured> getAllFeaturedProperty();

	    public boolean deleteFeaturedProperty(String cid);

	    public List<Featured> getPropertyID();
	    public boolean saveProperty(Featured nobj);
}
