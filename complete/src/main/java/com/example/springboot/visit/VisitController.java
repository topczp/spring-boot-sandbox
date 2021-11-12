package com.example.springboot.visit;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author topczp
 */
@RestController
class VisitController {
    @Autowired
	private final VisitRepository visits;

	public VisitController(VisitRepository visits) {
		this.visits = visits;
	}

	// @InitBinder
	// public void setAllowedFields(WebDataBinder dataBinder) {
	// 	dataBinder.setDisallowedFields("id");
	// }

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		visits.save(new Visit());
		long visitSoFar = visits.count();
		return "Greetings from Spring Boot! Visit so far " + visitSoFar;
	}


	// /**
	//  * Called before each and every @RequestMapping annotated method. 2 goals: - Make sure
	//  * we always have fresh data - Since we do not use the session scope, make sure that
	//  * Pet object always has an id (Even though id is not part of the form fields)
	//  * @param petId
	//  * @return Pet
	//  */
	// @ModelAttribute("visit")
	// public Visit loadPetWithVisit(@PathVariable("petId") int petId, Map<String, Object> model) {
	// 	Pet pet = this.pets.findById(petId);
	// 	pet.setVisitsInternal(this.visits.findByPetId(petId));
	// 	model.put("pet", pet);
	// 	Visit visit = new Visit();
	// 	pet.addVisit(visit);
	// 	return visit;
	// }

	// // Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
	// @GetMapping("/owners/*/pets/{petId}/visits/new")
	// public String initNewVisitForm(@PathVariable("petId") int petId, Map<String, Object> model) {
	// 	return "pets/createOrUpdateVisitForm";
	// }

	// // Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
	// @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
	// public String processNewVisitForm(@Valid Visit visit, BindingResult result) {
	// 	if (result.hasErrors()) {
	// 		return "pets/createOrUpdateVisitForm";
	// 	}
	// 	else {
	// 		this.visits.save(visit);
	// 		return "redirect:/owners/{ownerId}";
	// 	}
	// }

}