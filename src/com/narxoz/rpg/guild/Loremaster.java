package com.narxoz.rpg.guild;

public class Loremaster extends GuildMember {
    public Loremaster(String name, GuildMediator mediator) { super(name, mediator); }

    @Override
    public void receive(String topic,GuildMember from, String payload){
        String senderName=(from==null)?"System": from.getName();
        System.out.println("[" + getClass().getSimpleName() +" " + getName()+"] Received from " +senderName +" on " +topic+": "+payload);}
}