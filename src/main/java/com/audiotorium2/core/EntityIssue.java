package com.audiotorium2.core;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Issue")
public class EntityIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int user_id;
    private String issue_name;

    public EntityIssue() {

    }

    public EntityIssue(int user_id, String issue_name) {
        this.user_id = user_id;
        this.issue_name = issue_name;
    }
}
