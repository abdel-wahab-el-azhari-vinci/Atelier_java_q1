package domaine;

import java.time.Duration;

public class Instruction {
    private String description ;
    private Duration dureeEnMinutes;

    public Instruction(String description, int dureeMinutes) {
        this.description = description;
        this.dureeEnMinutes= Duration.ofMinutes(dureeMinutes) ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Duration getDureeMinutes() {
        return dureeEnMinutes;
    }

    public void setDureeMinutes(Duration dureeMinutes) {
        this.dureeEnMinutes = dureeMinutes;
    }




    @Override
    public String toString(){
        long hours = dureeEnMinutes.toHours();
        long minutes = dureeEnMinutes.toMinutes() % 60;
        return String.format("(%02d:%02d) %s", hours, minutes, description);
    }
}
