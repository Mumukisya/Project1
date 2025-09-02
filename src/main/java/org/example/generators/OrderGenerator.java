package org.example.generators;

import org.example.models.CreateOrderRequest;
import org.example.models.Ingredient;
import org.example.models.IngredientsResponse;

import java.util.List;
import java.util.stream.Collectors;

public class OrderGenerator {


    public static List<String> extractIngredientIds(IngredientsResponse ingredientsResponse) {
        return ingredientsResponse.getData().stream()
                .map(Ingredient::getId)
                .collect(Collectors.toList());
    }

    public static CreateOrderRequest createOrderWithMinimumIngredients(List<String> ingredientIds) {
        if (ingredientIds.size() < 2) {
            throw new IllegalArgumentException("Need at least 2 ingredients to create valid order");
        }
        return new CreateOrderRequest(List.of(ingredientIds.get(0), ingredientIds.get(1)));
    }

    public static CreateOrderRequest createOrderWithMultipleIngredients(List<String> ingredientIds) {
        if (ingredientIds.size() < 3) {
            throw new IllegalArgumentException("Need at least 3 ingredients to test multiple ingredients case");
        }
        return new CreateOrderRequest(ingredientIds.subList(0, 3));
    }
}
