package com.alfa.battle.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Branches
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2020-06-27T15:13:40.716+04:00")
@Entity
public class Branches {
    private String address = null;

    @Id
    private Long id = null;

    private Double lat = null;

    private Double lon = null;

    private String title = null;

    public Branches address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get address
     *
     * @return address
     **/
    @ApiModelProperty(value = "")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Branches id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Branches lat(Double lat) {
        this.lat = lat;
        return this;
    }

    /**
     * Get lat
     *
     * @return lat
     **/
    @ApiModelProperty(value = "")
    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Branches lon(Double lon) {
        this.lon = lon;
        return this;
    }

    /**
     * Get lon
     *
     * @return lon
     **/
    @ApiModelProperty(value = "")
    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Branches title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    @ApiModelProperty(value = "")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Branches branches = (Branches) o;
        return Objects.equals(this.address, branches.address) &&
                Objects.equals(this.id, branches.id) &&
                Objects.equals(this.lat, branches.lat) &&
                Objects.equals(this.lon, branches.lon) &&
                Objects.equals(this.title, branches.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, id, lat, lon, title);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Branches {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    lat: ").append(toIndentedString(lat)).append("\n");
        sb.append("    lon: ").append(toIndentedString(lon)).append("\n");
        sb.append("    title: ").append(toIndentedString(title)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

