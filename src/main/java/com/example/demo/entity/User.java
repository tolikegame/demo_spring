package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "dept")
    private  String dept;

    @Column(name = "e_mail")
    private String eMail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id",referencedColumnName = "id")
    private Detail detail;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_project",joinColumns = @JoinColumn(name = "user_id"),
                                     inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projects;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
