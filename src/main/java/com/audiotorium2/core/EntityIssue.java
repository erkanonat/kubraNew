package com.audiotorium2.core;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Issue")
public class EntityIssue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public int user_id;
    public String issue_name;
    public int status;

    public EntityIssue() {

    }

    public EntityIssue(int user_id, String issue_name,int status) {
        this.user_id = user_id;
        this.issue_name = issue_name;
        this.status=status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getIssue_name() {
        return issue_name;
    }

    public void setIssue_name(String issue_name) {
        this.issue_name = issue_name;
    }

    public String getStatusText() {
        if(status==0){
            return "initial";
        }else if(status==1) {
            return "waiting offer";
        } else if (status==2) {
            return "waiting approval ";
        } else {
            return "approved";
        }
    }
}
