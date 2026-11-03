package com.example.chatgptbasedcookingingredients;
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
public record OpenAIMessages(String role,
                             String content) {
}
