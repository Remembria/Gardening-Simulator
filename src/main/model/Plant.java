package model;

import java.util.ArrayList;

//A representation of the plant agent, including its L-System
public class Plant extends LindenmayerSystem {

    public final int growthRate;

    // CONSTRAINT: 0 <= thirst <= 10, where 0 is well watered, and 10 deathly dry
    private float thirst;
    private float progressToGrow;
    private String name;

    // REQUIRES: The alphabet of the axiom is valid (within the set {"F", "+", "-", "[", "]"})
    // EFFECTS: Generates a plant seed
    public Plant(String name, String axiom) {
        this.name = name;
        super.lindenString = axiom;
        growthRate = (int) Math.max(10, (Math.round(Math.random() * 100)));
        progressToGrow = growthRate;
        super.setPredecessorsAndSuccessors("F", "FF-[-F+F+F]+[+F-F-F]");
    }

    // MODIFIES: this
    // EFFECTS: If the plant is healthy, updates its linden system to grow new branches
    public void grow() {
        if (thirst <= 5) {
            super.updateLindenSystem();
        }
    }

    // MODIFIES: this
    // EFFECTS: Decreases the value of thirst by 1
    public void water() {
        thirst = Math.max((thirst - 1), 0);
    }

    // REQUIRES: 0 <= thirst <= 10
    // EFFECTS: Returns how healthy the plant currently is
    public String health() {
        if (thirst <= 1) {
            return "Freshly Watered!!";
        } else if (thirst <= 3) {
            return "Healthy";
        } else if (thirst <= 6) {
            return "Thirsty...";
        } else if (thirst <= 9) {
            return "VERY THIRSTY";
        } else {
            return "S.O.S.";
        }
    }

    public void setThirst(float t) {
        thirst = t;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgressToGrow(float v) {
        progressToGrow = v;
    }

    public float getProgressToGrow() {
        return progressToGrow;
    }

    public float getThirst() {
        return thirst;
    }

    public String getName() {
        return name;
    }

}
