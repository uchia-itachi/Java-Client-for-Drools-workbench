package com.mpowered.commons.pojo;
import java.util.List;
public class MpoweredUser {

    /**
     * Id stored in Mpowered DB
     */
    private String id;

    /**
     * Id referencing the resource this user belongs to
     */
    private String referenceId;

    /**
     * Primary ID in the IDP (Identity Provider)
     */
    private String pId;

    /**
     * Type of the user, Patient, Organisation or Practitioner
     */
    private String userResourceType;

    /**
     * Authentication provider
     */
    private String provider;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    public MpoweredUser(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUserResourceType() {
        return userResourceType;
    }

    public void setUserResourceType(String userResourceType) {
        this.userResourceType = userResourceType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    /**
     * Authorities that this user has
     */
//    private List<? extends GrantedAuthority> grantedAuthorityList;

}