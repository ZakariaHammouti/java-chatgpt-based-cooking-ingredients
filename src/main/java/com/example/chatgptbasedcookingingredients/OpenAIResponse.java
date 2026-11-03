package com.example.chatgptbasedcookingingredients;
//{

import java.util.List;

//        "choices": [
//        {
//        "index": 0,
//        "message": {
//        "role": "assistant",
//        "content": "Hello! How can I assist you today?",
//        },
//        }
//        ],
public record OpenAIResponse(List<OpenAiChoice> choices) {
}
