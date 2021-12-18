package org.bsuir.ppvis.model;

public class UserContext {
    private User user;
    private Recipe unfinishedRecipe;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Recipe getUnfinishedRecipe() {
        return unfinishedRecipe;
    }

    public void setUnfinishedRecipe(Recipe unfinishedRecipe) {
        this.unfinishedRecipe = unfinishedRecipe;
    }
}
