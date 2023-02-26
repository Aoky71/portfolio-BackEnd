package com.portfolio.backend.model;

import javax.persistence.*;;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombreSkill;
    private int gradoSkill;

    public Skill() {
    }

    public Skill(Long id, String nombreSkill, int gradoSkill) {
        this.id = id;
        this.nombreSkill = nombreSkill;
        this.gradoSkill = gradoSkill;
    }

}
