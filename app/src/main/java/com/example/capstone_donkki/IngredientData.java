package com.example.capstone_donkki;

public class IngredientData {
    private int ingredientImage;
    private String ingredientName;
    private int expiration;

    public IngredientData(int ingredientImage, String ingredientName, int expiration) {
        this.ingredientImage = ingredientImage;
        this.ingredientName = ingredientName;
        this.expiration = expiration;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getIngredientImage() {
        return ingredientImage;
    }

    public void setIngredientImage(int ingredientImage) {
        this.ingredientImage = ingredientImage;
    }

}
