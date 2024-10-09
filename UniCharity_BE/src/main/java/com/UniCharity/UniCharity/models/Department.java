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
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("1")
    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @OneToMany(mappedBy = "department")
    private Set<Campaign> campaigns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<FacultyRequest> facultyRequests = new LinkedHashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Scholarship> scholarships = new LinkedHashSet<>();

}