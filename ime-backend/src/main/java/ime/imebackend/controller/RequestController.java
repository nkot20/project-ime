package ime.imebackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ime.imebackend.entity.Request;
import ime.imebackend.services.RequestService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("http://localhost:4200")
public class RequestController {

	@Autowired
	private RequestService requestService;
	
	@PostMapping("/saveRequest")
	public Request saverequest(@RequestBody Request request) {
		return requestService.saveRequest(request);
	}
}
