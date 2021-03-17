package ime.imebackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ime.imebackend.entity.Request;
import ime.imebackend.repository.RequestRepository;

@Service
public class RequestService {

	@Autowired
	private RequestRepository requestRepo;
	
	public Request saveRequest(Request request) {
		return requestRepo.save(request);
	}
	
}
