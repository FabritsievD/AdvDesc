package com.Advertisements.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@Entity
@Table(name = "adverts")
@Proxy(lazy = false)
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('All','Realty','Vehicles','Electronics','Sport','Clothes')")
    private Section section;

    @Column
    private String description;

    @Column
    private int price;


    public Advert() {
    }

    public Advert(String title, Section section, String description, int price) {
        this.title = title;
        this.section = section;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = Section.valueOf(section);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Advert{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", section=" + section +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
