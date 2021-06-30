package javacamp.hrms.ws.client.kps.service;

import javacamp.hrms.ws.client.kps.generated.TCKimlikNoDogrula;
import javacamp.hrms.ws.client.kps.generated.TCKimlikNoDogrulaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

public class KPSClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(KPSClient.class);

    public boolean mernisValidation(Long identityNumber, String firstName, String lastName, int birthDate) {

        TCKimlikNoDogrula request = new TCKimlikNoDogrula();
        request.setTCKimlikNo(identityNumber);
        request.setAd(firstName);
        request.setSoyad(lastName);
        request.setDogumYili(birthDate);

        logger.info("Mernis dogrulama - TC:{}, Ad:{}, Soyad:{}, Dogum Yılı:{}", identityNumber, firstName, lastName, birthDate);

        createWebServiceTemplate();

        TCKimlikNoDogrulaResponse response = (TCKimlikNoDogrulaResponse) getWebServiceTemplate().marshalSendAndReceive(
                "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx",
                request,
                webServiceMessage -> {
                    ((SoapMessage) webServiceMessage).setSoapAction("http://tckimlik.nvi.gov.tr/WS/TCKimlikNoDogrula");
                });

        return response.isTCKimlikNoDogrulaResult();
    }

    private void createWebServiceTemplate(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("javacamp.hrms.ws.client.kps.generated");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);
    }

}
