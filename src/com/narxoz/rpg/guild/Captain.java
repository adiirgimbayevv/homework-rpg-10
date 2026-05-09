package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for orders and mission coordination.
 */
public class Captain extends GuildMember {

    public Captain(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void issueOrder(String topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic,GuildMember from, String payload){
        String senderName=(from==null)?"System": from.getName();
        System.out.println("[" + getClass().getSimpleName() +" " + getName()+"] Received from " +senderName +" on " +topic+": "+payload);}
}
