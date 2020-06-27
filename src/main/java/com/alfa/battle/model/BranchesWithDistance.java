package com.alfa.battle.model;

/**
 * Branches
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:13:40.716+04:00")
public class BranchesWithDistance extends Branches {

    private String address;

    private Long id;

    private Double lat;

    private Double lon;

    private String title;

    private Long distance;

    public BranchesWithDistance(Branches branches) {
        this.id = branches.getId();
        this.lat = branches.getLat();
        this.lon = branches.getLon();
        this.address = branches.getAddress();
        this.title = branches.getTitle();
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }
}

