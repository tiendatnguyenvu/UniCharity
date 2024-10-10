package com.UniCharity.UniCharity.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @OneToMany(mappedBy = "createdBy")
    private Set<Campaign> campaigns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Donation> donations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "faculty")
    private Set<FacultyRequest> facultyRequests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "student")
    private Set<StudentApplication> studentApplications = new LinkedHashSet<>();

}