package fr.bugo.games.loveletter.shareddata.models;

import lombok.Data;

@Data
public abstract class APlayer {

    // *****************************************************************************************************************
    // ATTRIBUTES
    // *****************************************************************************************************************

    protected User user;

    // *****************************************************************************************************************
    // CONSTRUCTOR
    // *****************************************************************************************************************

    public APlayer() {}

    public APlayer(User user) {
        this.user = user;
    }

    // *****************************************************************************************************************
    // ABSTRACT METHODS
    // *****************************************************************************************************************

    // *****************************************************************************************************************
    // OVERRIDE METHODS
    // *****************************************************************************************************************

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("APlayer{");
        sb.append("name='").append(user).append('\'');
        sb.append('}');
        return sb.toString();
    }
}