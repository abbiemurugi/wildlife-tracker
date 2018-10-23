import org.sql2o.Connection;

public class Animal {

    import org.sql2o.Connection;

    private String name;
    private String ranger;
    private String age;
    private String location;
    private String health;
    private String status;
    private Timestamp spotted;
    private int id;

    public Animal (String name, String ranger, String age, String location, String health, String status){
        this.name = name;
        this.ranger = ranger;
        this.age = age;
        this.location = location;
        this.health = health;
        this.status = status;


    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getRanger() {
        return ranger;
    }

    public String getHealth() {
        return health;
    }

    public String getAge() {
        return age;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getSpotted() {
        return spotted;
    }

    public int getId() {
        return id;
    }


    public static List<Animal> all() {
        String sql = "SELECT name, ranger, age, location, health, status, spotted FROM animals";
        try (Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Animal.class);
        }
    }

    @Override
    public boolean equals(Object otherAnimal) {
        if (!(otherAnimal instanceof Animal)) {
            return false;
        } else {
            Animal newAnimal = (Animal) otherAnimal;
            return this.getName().equals(newAnimal.getName()) &&
                    this.getRanger().equals(newAnimal.getRanger()) &&
                    this.getAge().equals(newAnimal.getAge()) &&
                    this.getLocation().equals(newAnimal.getLocation()) &&
                    this.getHealth().equals(newAnimal.getHealth()) &&
                    this.getStatus().equals(newAnimal.getStatus()) &&
                    this.getId() == newAnimal.getId();

        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, ranger, age, location, health, status, spotted ) VALUES (:name, :ranger, :age, :location, :health, :status, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("ranger", this.ranger)
                    .addParameter("age", this.age)
                    .addParameter("location", this.location)
                    .addParameter("health", this.health)
                    .addParameter("status", this.status)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Animal find(int id) {
        try (Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM animals where id=:id";
            Animal animal = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Animal.class);
            return animal;
        }
    }
}