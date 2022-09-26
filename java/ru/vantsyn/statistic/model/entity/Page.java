package ru.vantsyn.statistic.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "page")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "href")
    private String href;

    @OneToMany(mappedBy = "page", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Page2User> page2Users;

    public Page() {
    }

    public Page(String name, String href) {
        this.name = name;
        this.href = href;
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
