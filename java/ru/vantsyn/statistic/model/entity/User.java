package ru.vantsyn.statistic.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Page2User> page2Users;

    public User() {}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                '}';
    }

    public List<Page2User> getPage2Users() {
        return page2Users;
    }

    public void setPage2Users(List<Page2User> page2Users) {
        this.page2Users = page2Users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}