package com.bvr;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pathology")
public class PathologyService {

	public PathologyService() {
		// TODO Auto-generated constructor stub
	}
	
	List<Disease> diseases = Arrays.asList(
			new Disease("d1", "Diabetes", "A chronic condition that affects the way the body processes blood sugar (glucose)."),
			new Disease("d2", "Hypertension", "A condition in which the force of the blood against the artery walls is too high."),
			new Disease("d3", "Asthma", "A condition in which a person's airways become inflamed, narrow and swell, producing extra mucus, making it difficult to breathe.")
	);

	@RequestMapping("/diseases")
	public DiseaseList getDiseases() {
		DiseaseList diseaseList = new DiseaseList();
		diseaseList.setDiseases(diseases);
		return diseaseList;
	}


	@RequestMapping("/diseases/{id}")
	public Disease getDisease(@PathVariable("id") String id) {
		Disease disease = diseases.stream()
				.filter(d -> id.equals(d.getId()))
				.findAny()
				.orElse(null);
		return disease;
	}


}
