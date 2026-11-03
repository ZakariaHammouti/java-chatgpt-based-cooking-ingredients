package com.example.chatgptbasedcookingingredients;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.servlet.tags.form.AbstractDataBoundFormElementTag;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    String prompt = "Bestimme anhand der Zutaten, ob das Rezept vegan, " +
            "vegetarisch oder normal ist." +
            "Antworte ausschließlich mit einem dieser Wörter: " +
            "vegan, vegetarisch oder normal.";



    /*String[] ingredient = {
            //Normal
            " Zutaten: 200g Nudeln, 200ml Sahne, 200g passierte Tomaten," +
                    " Salz, Pfeffer, Kräuter, Käse " ,
            //Vegan
            "Zutaten: 150g Reis, 1 Paprika, 1 Karotte, 100g Erbsen, 2 EL Sojasoße, Öl ",
            //Vegetarisch
            " Zutaten: 400g Kartoffeln, 1 Zucchini, 1 Paprika, 150ml Sahne," +
                    " 100g geriebener Käse, Salz, Pfeffer "
    };*/


    public final RestClient restClient;

    public IngredientController(@Value("${app.openai-api-key}") String openaiApiKey) {

        this.restClient = RestClient.builder()
                .baseUrl("https://api.openai.com/v1/chat/completions")
                .defaultHeader("Authorization", "Bearer " + openaiApiKey)
                .build();
    }

    @PostMapping
    String categorizeIngredient(@RequestBody String ingredient) {

        // TODO: This should return "vegan", "vegetarian" or "regular" depending on the ingredient.

        List<OpenAIMessages> messages = List.of(
                new OpenAIMessages("developer",
                        prompt),
                new OpenAIMessages("user", ingredient)
        );

        OpenAIRequest request = new OpenAIRequest("gpt-4-mini", messages);

        OpenAIResponse response = restClient.post()
                .body(request)
                .retrieve()
                .body(OpenAIResponse.class);

        String result = response.choices()
                .getFirst()
                .message()
                .content()
                .trim();

        System.out.println(result);

        return result;
    }
}
