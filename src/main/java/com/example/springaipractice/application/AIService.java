package com.example.springaipractice.application;

import static org.springframework.ai.openai.api.OpenAiApi.ChatModel.*;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.converter.BeanOutputConverter;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.ai.openai.api.ResponseFormat;
import org.springframework.stereotype.Service;

import com.example.springaipractice.presentation.AIRequestDto;
import com.example.springaipractice.presentation.AIResponseDto;

@Service
public class AIService {

	private final ChatClient chatClient;

	public AIService(ChatClient chatClient) {
		this.chatClient = chatClient;
	}

	public AIResponseDto generate(AIRequestDto request) {
		BeanOutputConverter<AIResponseDto> outputConverter = new BeanOutputConverter<>(AIResponseDto.class);
		Prompt prompt = createPrompt(request.content(), outputConverter);
		String responseContent = executePrompt(prompt);

		return outputConverter.convert(responseContent);
	}

	private Prompt createPrompt(String content, BeanOutputConverter<AIResponseDto> outputConverter) {
		String jsonSchema = outputConverter.getJsonSchema();
		OpenAiChatOptions options = OpenAiChatOptions.builder()
			.model(GPT_4_O_MINI)
			.responseFormat(new ResponseFormat(ResponseFormat.Type.JSON_SCHEMA, jsonSchema))
			.build();

		return new Prompt(content, options);
	}

	private String executePrompt(Prompt prompt) {
		ChatResponse chatResponse = chatClient.prompt(prompt)
			.call()
			.chatResponse();

		if (chatResponse == null) {
			throw new IllegalStateException("AI response is null");
		}

		return chatResponse
			.getResult()
			.getOutput()
			.getText();
	}
}
