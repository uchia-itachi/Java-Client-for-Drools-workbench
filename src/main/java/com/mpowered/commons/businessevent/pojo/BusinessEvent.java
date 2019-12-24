package com.mpowered.commons.businessevent.pojo;

import java.util.Date;

public class BusinessEvent {
    BusinessEventType businessEventType = BusinessEventType.BILL_PAY;
    String referenceId;
    String username;
    Date eventTime;
    Long amount = 1000L;

    public BusinessEvent(){

    }

    public BusinessEventType getBusinessEventType() {
        return businessEventType;
    }

    public void setBusinessEventType(BusinessEventType businessEventType) {
        this.businessEventType = businessEventType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
