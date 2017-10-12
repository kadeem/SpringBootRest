package de.pifrasso.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Defect {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private User creationUser;

    @ManyToOne
    private DefectCode defectCode;

    private String description;
//<xs:element minOccurs="0" name="DeviceId" type="xs:long"/>
//<xs:element minOccurs="0" name="LocoDefectCodeId" nillable="true" type="xs:long"/>
//<xs:element minOccurs="0" name="LocoId" nillable="true" type="xs:long"/>
//<xs:element minOccurs="0" name="Position" nillable="true" type="xs:base64Binary"/>
//<xs:element minOccurs="0" name="SchadEreignisId" nillable="true" type="xs:long"/>
// <xs:element minOccurs="0" name="SchadPositionId" nillable="true" type="xs:long"/>
//<xs:element minOccurs="0" name="Severity" nillable="true" type="xs:int"/>
//<xs:element minOccurs="0" name="TransactionKey" nillable="true" type="xs:string"/>
    @ManyToOne
    private Waggon waggon;


    protected Defect() {
    }

    public Defect(User creationUser, DefectCode defectCode, String description, Waggon waggon) {
        this.creationUser = creationUser;
        this.defectCode = defectCode;
        this.description = description;
        this.waggon = waggon;
    }

    public long getId() {
        return id;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public DefectCode getDefectCode() {
        return defectCode;
    }

    public void setDefectCode(DefectCode defectCode) {
        this.defectCode = defectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Waggon getWaggon() {
        return waggon;
    }

    public void setWaggon(Waggon waggon) {
        this.waggon = waggon;
    }
}
