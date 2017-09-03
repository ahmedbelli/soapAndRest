package com.github.trainings.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.github.patient.Patient;

public class JAXBDemo {

	public static void main(String[] args) {
		
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller createMarshaller = context.createMarshaller();
			
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("Jose Castillo");
			
			StringWriter writer = new StringWriter();
			createMarshaller.marshal(patient, writer);
			
			System.out.println(writer.toString());
			
			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			Patient patientResult =  (Patient)unmarshaller.unmarshal(new StringReader(writer.toString()));
			
			System.out.println(patientResult.getName());
			
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
