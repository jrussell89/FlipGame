public class Job {
    public static double[] wages = {25,50,100};
    public static String[] jobs = {"Job1", "Job2", "Job3"};
    private String job;
    private double wage;
    private Character character;

    public Job(Character character, int which) {
        this.job = jobs[which];
        this.character = character;
        character.setJob(this);
        this.wage = Math.ceil(wages[which] * character.getEducation().getMoneyMultiplyer());
        character.setWage(wage);
    }

    public double[] getWages() {
        return wages;
    }
    public double getWage() {
        return wage;
    }
    public void pay() {
        character.addToCash(wage);
    }

    @Override
    public String toString() {
        return job;
    }
}