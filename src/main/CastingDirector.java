package main;

import java.util.*;

public class CastingDirector {
    private final List<Actor> currentCast;
    private final List<Actor> collideCheckList;
    private final Set<Actor> removedActors;

    public CastingDirector() {
        currentCast = new ArrayList<>();
        collideCheckList = new ArrayList<>();
        removedActors = new HashSet<>();
    }

    public List<Actor> getCurrentCast() {
        return currentCast;
    }

    public void addCurrentCast(Actor... actors) {
        currentCast.addAll(Arrays.asList(actors));
    }

    public void removeCurrentCast(Actor... actors) {
        currentCast.removeAll(Arrays.asList(actors));
    }

    public void resetCurrentCast() {
        currentCast.clear();
    }

    public List getCollideCheckList() {
        return collideCheckList;
    }

    public void resetCollideCheckList() {
        collideCheckList.clear();
        collideCheckList.addAll(currentCast);
    }

    public Set getRemovedActors() {
        return removedActors;
    }

    public void addToRemovedActors(Actor... actors) {
        if(actors.length > 1)
            removedActors.addAll(Arrays.asList((Actor[]) actors));
        else
            removedActors.add(actors[0]);
    }

    public void resetRemovedActors() {
        currentCast.removeAll(removedActors);
        removedActors.clear();
    }
}
