package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for gear, supplies, and rewards.
 */
public class Quartermaster extends GuildMember {

    public Quartermaster(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void requestSupplies(String topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic,GuildMember from, String payload){
        String senderName=(from==null)?"System": from.getName();
        System.out.println("[" + getClass().getSimpleName() +" " + getName()+"] Received from " +senderName +" on " +topic+": "+payload);}
}
