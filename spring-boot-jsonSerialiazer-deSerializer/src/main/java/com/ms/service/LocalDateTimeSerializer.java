package com.ms.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

	static final DateTimeFormatter FOMATTER = DateTimeFormatter.ofPattern("MM/dd/yyyy 'at' hh:mm a");

	@Override
	public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		try {
			String s = value.format(FOMATTER);
			gen.writeString(s);
		} catch (DateTimeParseException pe) {
			log.info("Exception occured during serialization: " + pe.getMessage());
		} catch (Exception e) {
			log.info("Unknown exception occured: " + e.getMessage());
			throw e;
		}
	}
}
