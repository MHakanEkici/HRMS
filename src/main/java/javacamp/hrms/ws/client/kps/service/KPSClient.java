package javacamp.hrms.ws.client.kps.service;

import javacamp.hrms.ws.client.kps.generated.TCKimlikNoDogrula;
import javacamp.hrms.ws.client.kps.generated.TCKimlikNoDogrulaResponse;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

public class KPSClient {

    private static final Logger logger = LoggerFactory.getLogger(KPSClient.class);
    
    public boolean mernisValidation(Long identityNumber, String firstName, String lastName, int birthDate) throws SOAPException {

        TCKimlikNoDogrula request = new TCKimlikNoDogrula();
        request.setTCKimlikNo(identityNumber);
        request.setAd(firstName);
        request.setSoyad(lastName);
        request.setDogumYili(birthDate);

        logger.info("Mernis dogrulama - TC:{}, Ad:{}, Soyad:{}, Dogum Yılı:{}", identityNumber, firstName, lastName, birthDate);

        WebServiceTemplate template = createWebServiceTemplate();

        TCKimlikNoDogrulaResponse response = (TCKimlikNoDogrulaResponse) template.marshalSendAndReceive(
                "https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx",
                request
               );

        return response.isTCKimlikNoDogrulaResult();
    }
    
    private WebServiceTemplate createWebServiceTemplate() throws SOAPException{
    	SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory(MessageFactory.newInstance());
    	messageFactory.createWebServiceMessage();
        messageFactory.afterPropertiesSet();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(messageFactory);

        webServiceTemplate.setDefaultUri("https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx");

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("javacamp.hrms.ws.client.kps.generated");
        webServiceTemplate.setMarshaller(marshaller);
        webServiceTemplate.setUnmarshaller(marshaller);

        return webServiceTemplate;
    }     

}
