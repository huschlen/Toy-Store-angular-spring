package com.naoko.inventory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;
import com.naoko.inventory.service.IToyService;
import com.naoko.inventory.entity.Toy;

@Controller
@RequestMapping("/toy-store")
public class ToyController {
	@Autowired
	private IToyService toyService;
	@RequestMapping("/home")
	public String home() {
 		return "home";
 	}
	@RequestMapping(value="/toy/{id}", method = RequestMethod.GET )
	public ResponseEntity<Toy> getToyById(@PathVariable("id") Integer id) {
		Toy toy = toyService.getToyById(id);
		return new ResponseEntity<Toy>(toy, HttpStatus.OK);
	}
	@RequestMapping(value= "/toy", method = RequestMethod.GET)
	public ResponseEntity<List<Toy>> getAllToys() {
		List<Toy> list = toyService.getAllToys();
		return new ResponseEntity<List<Toy>>(list, HttpStatus.OK);
	}
	@RequestMapping(value= "/toy", method = RequestMethod.POST)
	public ResponseEntity<Void> toyService(@RequestBody Toy toy, UriComponentsBuilder builder) {
        boolean flag = toyService.addToy(toy);
    	if (flag == false) {
    		new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/toy/{id}").buildAndExpand(toy.getTid()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}	
	@RequestMapping(value="/toy/{id}", method = RequestMethod.PUT )
	public ResponseEntity<Toy> updateToy(@RequestBody Toy toy) {
		toyService.updateToy(toy);
		return new ResponseEntity<Toy>(toy, HttpStatus.OK);
	}	
	@RequestMapping(value="/toy/{id}", method = RequestMethod.DELETE )
	public ResponseEntity<Void> deleteToy(@PathVariable("id") Integer id) {
		toyService.deleteToy(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}