import org.sql2o.Connection;

public class Animal {

    import org.sql2o.Connection;

    private String name;
    private String location;
    private String health;
    private String status;
    private String timestamp;
    private ranger;
    private int id;

    public Animal (String name, String location, String health, String status, String timestamp, String ranger){
        this.name = name;
        this.ranger = location;
        this.age = health;
        this.location = status;
        this.health = timestamp;
        this.status = ranger;


    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getHealth() {
        return ranger;
    }

    public String getStatus() {
        return health;
    }

    public String getTimeStamp() {
        return timestamp;
    }

    public String getRanger() {
        return ranger;
    }

    public int getId() {
        return id;
    }


    public static List<Animal> all() {
        String sql = "SELECT name, location, health, status, timestamp, ranger, ";
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
                    this.getLocation().equals(newAnimal.getLocation()) &&
                    this.getHealth().equals(newAnimal.getHealth()) &&
                    this.getStatus().equals(newAnimal.getStatus()) &&
                    this.getTimeStamp().equals(newAnimal.getTimeStamp()) &&
                    this.getRanger().equals(newAnimal.getRanger())) &&
                    this.getId() == newAnimal.getId();

        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals (name, ranger, age, location, health, status, spotted ) VALUES (:name, :ranger, :age, :location, :health, :status, now())";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("location", this.location)
                    .addParameter("health", this.health)
                    .addParameter("status", this.status)
                    .addParameter("timestamp", this.timestamp)
                    .addParameter("ranger", this.ranger)
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