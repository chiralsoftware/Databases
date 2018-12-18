package chiralsoftware.javajpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
    
    @Id
    private long id;
    
    private String name;
    private int age;
    
    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", age=" + age + '}';
    }
    
}
