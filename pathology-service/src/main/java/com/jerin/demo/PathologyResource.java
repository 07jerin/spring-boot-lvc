package com.jerin.demo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	private List<Disease> diseases = Arrays.asList(
			
			new Disease("D1", "Astama", "Hot waster vapor"),
			new Disease("D2", "HeadAche", "Hot water bath"),
			new Disease("D3", "Corona", "Wash hands and stay safe")
			);
	
	
	@RequestMapping("/diseases")
	public DiseaseList diseases() {
		DiseaseList list = new DiseaseList();
		list.setDiseases(diseases);
		return list;
	} 
	
	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id) {
		Disease disease = diseases.stream()
				.filter(d -> d.getId().equalsIgnoreCase(id))
				.findAny().orElse(null);
		
		return disease;
	}
			

}
