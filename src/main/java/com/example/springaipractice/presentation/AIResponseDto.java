package com.example.springaipractice.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public record AIResponseDto(
	@JsonProperty(required = true, value = "summary") String summary,
	@JsonProperty(required = true, value = "field") String field
) {
}
