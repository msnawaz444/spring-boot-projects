package com.ms;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.model.CurrencyRate;

@SpringBootApplication
public class MsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		CurrencyRate cr = new CurrencyRate();
		cr.pair("USD/JPY");
		cr.rate(109.15);
		cr.lastUpdated(LocalDateTime.now());
		System.out.println("Java object: " + cr);
		
		
//		// Creating a module
//		SimpleModule module = new SimpleModule();
//
//		// adding our custom serializer and deserializer
//		module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
//		module.addDeserializer(LocalDateTime.class, new LocalDatetimeDeserializer());
//
//		// registering the module with ObjectMapper
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//		objectMapper.registerModule(module);

		
		
		ObjectMapper objectMapper=new ObjectMapper();
		String s2 = objectMapper.writeValueAsString(cr);
		System.out.println("JSON string: " + s2);

		CurrencyRate cr2 = objectMapper.readValue(s2, CurrencyRate.class);
		System.out.println("Java Object: " + cr2);

	}
}
