package com.ms.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDatetimeDeserializer extends JsonDeserializer<LocalDateTime> {

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String str = p.getText();
		try {
			return LocalDateTime.parse(str, LocalDateTimeSerializer.FOMATTER);
		} catch (DateTimeParseException pe) {
			log.info("Exception occured during de serialization: " + pe.getMessage());
			throw pe;
		} catch (Exception e) {
			log.info("Some unknown exception occured during de serialization: " + e.getMessage());
			throw e;
		}
	}
}
