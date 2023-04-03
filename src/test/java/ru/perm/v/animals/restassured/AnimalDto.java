package ru.perm.v.animals.restassured;

import java.util.Objects;

//TODO: Перенести в библиотеку
public class AnimalDto {

    private Long id = 0L;
    private String name = "";

    public AnimalDto() {
    }

    public AnimalDto(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnimalDto animalDto = (AnimalDto) o;
        return Objects.equals(id, animalDto.id) && Objects.equals(name, animalDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
