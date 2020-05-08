package com.ms.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ms.service.LocalDateTimeSerializer;
import com.ms.service.LocalDatetimeDeserializer;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true, fluent = true)
public class CurrencyRate{

	@JsonProperty("pair")
	private String pair;

	@JsonProperty("rate")
	private double rate;

	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@JsonDeserialize(using = LocalDatetimeDeserializer.class)
	@JsonProperty("lastUpdated")
	private LocalDateTime lastUpdated;
}
