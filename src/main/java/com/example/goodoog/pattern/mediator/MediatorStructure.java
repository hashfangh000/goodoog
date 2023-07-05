package com.example.goodoog.pattern.mediator;


import lombok.Getter;
import lombok.Setter;

/**
 * 具体的中介者角色类
 */
@Getter
@Setter
public class MediatorStructure extends Mediator{

    private HouseOwner houseOwner;

    private Tenant tenant;


    @Override
    public void connect(String msg, Person person) {
        if (person == houseOwner) {
            tenant.getMsg(msg);
        } else {
            houseOwner.getMsg(msg);
        }
    }
}
