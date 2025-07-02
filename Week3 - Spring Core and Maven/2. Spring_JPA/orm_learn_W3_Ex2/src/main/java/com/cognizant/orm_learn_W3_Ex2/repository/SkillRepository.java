package com.cognizant.orm_learn_W3_Ex2.repository;

import com.cognizant.orm_learn_W3_Ex2.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}
