package ait.com.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ait.com.entity.Uom;
import ait.com.service.UomService;



@RestController
public class UomRestController {

	@Autowired
	private UomService uomService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUoms(){
		ResponseEntity<?> response = null;
		
		
		try {
			List<Uom> uoms = uomService.getAllUoms();
			response = new ResponseEntity<List<Uom>>(uoms, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response ;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveStudent(@RequestBody Uom uom){
	   ResponseEntity<String> response = null;
	   try{
	     uomService.saveUom(uom);
	    response = new ResponseEntity<String>("Success !", HttpStatus.OK);
	   }
	   catch(Exception e){
	     response = new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	   }

	   return response;
	}
	
	@GetMapping("/edit/{id}")
	public ResponseEntity<?>  editStudent(@PathVariable("id") Integer id){
	   ResponseEntity<?> response = null;
	   try{
	          Uom uom = uomService.getUomById(id);
	          response = new ResponseEntity<Uom>(uom , HttpStatus.OK);
	   }catch(Exception e){
	          response = new ResponseEntity<String>("Not Exist !", HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	  return response ;
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id , @RequestBody Uom uom){
		ResponseEntity<?> response = null;
		
		try {
			Uom uomNew = uomService.getUomById(uom.getUomId()); 
			BeanUtils.copyProperties(uom, uomNew);
			uomService.updateUom(uomNew);
			response = new ResponseEntity<>("Updated !", HttpStatus.OK);
			
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Integer id ){
		ResponseEntity<String> response = null;
		
		try {
			uomService.deleteUom(id);
			response = new ResponseEntity<>("Deleted !", HttpStatus.OK);
			
		} catch (Exception e) {
			response = new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
}
