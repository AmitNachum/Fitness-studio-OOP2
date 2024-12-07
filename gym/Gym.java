package gym;
import gym.management.Secretary;
import gym.customers.Person;

public class Gym {
    private static final Gym gym = new Gym();
    private String name;
    private Secretary secretary;
    private int gymBalance;
    private int secretarySalary;

    private Gym() {
    }

    public static Gym getInstance() {
        return gym;
    }

    public int getSecretarySalary() {
        return secretarySalary;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }

    public void setSecretary(Person secretary, int salary) {
        this.secretary = new Secretary(secretary);
        this.secretary.getActionPrints().add("A new secretary has started working at the gym: " + this.secretary.getPerson().getName());
        setSalary(salary);
    }

    public void setSalary(int secretarySalary) {
        this.secretarySalary = secretarySalary;
    }

    public Secretary getSecretary() {
        return this.secretary;
    }

    public void addToGymBalance(int amount) {
        this.gymBalance += amount;
    }

    @Override
    public String toString() {
        return "Gym Name: " + name + "\n" +
                "Gym Secretary: " + secretary + "\n" +
                "Gym Balance: " + gymBalance + "\n" +
                "\n" +
                "Clients Data:" + "\n" +
                this.secretary.getClientRegistry() +
                "\n" +
                "Employees Data:" + "\n" +
                this.secretary.getInstructorRegistry() +
                secretary + "\n" +
                "\n" +
                "Sessions Data:" + "\n" +
                this.secretary.getSessionRegistry();

    }
}
