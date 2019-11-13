
package ohtu;

public class Player {
    private String name;
    private String team;
    private int goals;
    private int assists;
    private String nationality;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getGoals() {
        return goals;
    }

    public int getPoints() {
        return goals + assists;
    }
    public String getPointsString() {
        return goals + " + " + assists + " = " + this.getPoints();
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
