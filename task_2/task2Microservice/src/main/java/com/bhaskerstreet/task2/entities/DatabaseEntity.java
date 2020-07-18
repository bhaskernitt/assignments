package com.bhaskerstreet.task2.entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_info")
public class DatabaseEntity {

    public DatabaseEntity() {
    }

    public DatabaseEntity(String id, String parentId, String name, String color) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.color = color;
        this.parentId = Integer.parseInt(parentId);
    }

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "parent_id")
    private Integer parentId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "DatabaseEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
