package ait.com.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.com.entity.Uom;
import ait.com.exception.UomNotFoundException;
import ait.com.repo.UomRepository;
import ait.com.service.UomService;
@Service
public class UomServiceImpl implements UomService {
	
	@Autowired
	private UomRepository uomRepository;

	@Override
	public boolean saveUom(Uom uom) {
		
		return uomRepository.save(uom).getUomId()!=null;
	}

	@Override
	public List<Uom> getAllUoms() {
		
		return uomRepository.findAll();
	}

	@Override
	public Uom getUomById(Integer uomId) {
		Uom uom = null;
		Optional<Uom> optional = uomRepository.findById(uomId);
		if (optional.isPresent()) {
			uom = optional.get();
			return uom;
		}else {
			throw new UomNotFoundException("Uom is not exist !");
		}
	}

	@Override
	public void updateUom(Uom uom) {
		uomRepository.save(uom);
	}

	@Override
	public void deleteUom(Integer uomId) {
		uomRepository.deleteById(uomId);

	}

}
