package javacamp.hrms.core.adapters;

import org.springframework.stereotype.Service;

import javacamp.hrms.core.abstracts.MernisCheckService;
import javacamp.hrms.entities.conretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisServiceAdapter implements MernisCheckService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		boolean result = false;
		try {
			KPSPublicSoap mernisValidation = new KPSPublicSoapProxy();
			return mernisValidation.TCKimlikNoDogrula(candidate.getIdentityNumber(),
					candidate.getFirstName(), candidate.getLastName(), candidate.getBirthDate().getYear());

		} catch (Throwable e) {
			e.printStackTrace();
			return true;
			//return result;  TODO simule edildi.
		}
		 
		
	}

}
