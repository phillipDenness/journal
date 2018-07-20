package com.solirius.journal.domain;

import javax.persistence.Id;

import javax.persistence.*;

@Entity
@Table(name = "resource")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "resource_id")
    private Integer resourceId;

    @Column(name = "url")
    private String url;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
