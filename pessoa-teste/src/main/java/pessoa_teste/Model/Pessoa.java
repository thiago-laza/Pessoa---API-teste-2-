package pessoa_teste.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Pessoa {
    private @Id @GeneratedValue Long id;
    private String name;
    private int age;
    private Double weiht;
    private Double height;

    Pessoa(){}

    Pessoa(String name, int age, Double weight, Double height){
        this.name = name;
        this.age = age;
        this.weiht = weight;
        this.height = height;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getWeiht() {
        return weiht;
    }

    public void setWeiht(Double weiht) {
        this.weiht = weiht;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    
}
