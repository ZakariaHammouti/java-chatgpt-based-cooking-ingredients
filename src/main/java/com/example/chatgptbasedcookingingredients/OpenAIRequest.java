package com.example.chatgptbasedcookingingredients;

import java.util.List;

//{
//        "model": "gpt-6-astra",
//        "messages": [
//        {
//        "role": "developer",
//        "content": "You are a helpful assistant."
//        },
//        {
//        "role": "user",
//        "content": "Hello!"
//        }
//        ]
//        }
public record OpenAIRequest(String model,
                            List<OpenAIMessages> messages
) {
}
