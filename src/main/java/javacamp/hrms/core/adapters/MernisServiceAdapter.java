package javacamp.hrms.core.adapters;

import javacamp.hrms.ws.client.kps.service.KPSClient;
import org.springframework.stereotype.Service;

import javacamp.hrms.core.abstracts.MernisCheckService;
import javacamp.hrms.entities.conretes.Candidate;

@Service
public class MernisServiceAdapter implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		boolean result = false;
		try {
			KPSClient kpsClient = new KPSClient();
			return kpsClient.mernisValidation(candidate.getIdentityNumber(),
					candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate().getYear());

		} catch (Throwable e) {
			e.printStackTrace();
			return result;
		}
		
	}

}
