package ru.katin.kurs.model;

import jakarta.persistence.*;

@Entity
@Table(name = "types_pensions")
public class TypePension {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "base_size")
    private double base_size;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public double getBase_size() {
        return base_size;
    }

    public void setBase_size(double base_size) {
        this.base_size = base_size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", conditions=" + conditions + '\'' +
                ", base_size=" + base_size +
                '}';
    }


}
