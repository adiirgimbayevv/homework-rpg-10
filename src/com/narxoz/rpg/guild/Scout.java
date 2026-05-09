package com.narxoz.rpg.guild;

/**
 * Guild officer responsible for route reports and reconnaissance.
 */
public class Scout extends GuildMember {

    public Scout(String name, GuildMediator mediator) {
        super(name, mediator);
    }

    public void reportRoute(String topic, String payload) {
        getMediator().dispatch(topic, this, payload);
    }

    @Override
    public void receive(String topic,GuildMember from, String payload){
        String senderName=(from==null)?"System": from.getName();
        System.out.println("[" + getClass().getSimpleName() +" " + getName()+"] Received from " +senderName +" on " +topic+": "+payload);}
}
