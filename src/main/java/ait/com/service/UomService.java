package ait.com.service;

import java.util.List;

import ait.com.entity.Uom;

public interface UomService {

	public boolean saveUom(Uom uom);
	public List<Uom> getAllUoms();
	public Uom getUomById(Integer uomId);
	public void updateUom(Uom uom);
	public void deleteUom(Integer uomId);
	
}
