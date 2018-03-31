package org.demo.springbootmybatis.model;

import java.io.Serializable;

/**
 * Created by zhaol on 2017/12/22.
 */
public class Province implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private String description;
    private Integer countryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "Province{" + "id=" + id + ", code='" + code + '\'' + ", name='" + name + '\'' + ", description='" + description + '\'' + ", countryId=" + countryId + '}';
    }
}
