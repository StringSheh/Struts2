package com.itheima.bos.domain.base;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * FixedArea entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="T_FIXED_AREA"
    ,schema="EE66BOS"
)

public class FixedArea  implements java.io.Serializable {


    // Fields    

     private Long id;
     private Courier courier;
     private String fixedAreaName;
     private String telephone;
     private Set<SubArea> subAreas = new HashSet<SubArea>(0);


    // Constructors

    /** default constructor */
    public FixedArea() {
    }

    
    /** full constructor */
    public FixedArea(Courier courier, String fixedAreaName, String telephone, Set<SubArea> subAreas) {
        this.courier = courier;
        this.fixedAreaName = fixedAreaName;
        this.telephone = telephone;
        this.subAreas = subAreas;
    }

   
    // Property accessors
    @SequenceGenerator(name="generator",sequenceName="T_FIXED_AREA_SEQ",allocationSize=1)@Id @GeneratedValue(strategy=SEQUENCE, generator="generator")
    
    @Column(name="ID", unique=true, nullable=false, precision=10, scale=0)

    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="FIXED_AREA_LEADER")

    public Courier getCourier() {
        return this.courier;
    }
    
    public void setCourier(Courier courier) {
        this.courier = courier;
    }
    
    @Column(name="FIXED_AREA_NAME")

    public String getFixedAreaName() {
        return this.fixedAreaName;
    }
    
    public void setFixedAreaName(String fixedAreaName) {
        this.fixedAreaName = fixedAreaName;
    }
    
    @Column(name="TELEPHONE", length=100)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="fixedArea")

    public Set<SubArea> getSubAreas() {
        return this.subAreas;
    }
    
    public void setSubAreas(Set<SubArea> subAreas) {
        this.subAreas = subAreas;
    }
   








}