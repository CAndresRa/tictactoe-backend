package edu.escuelaing.arsw.tictactoe.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.websocket.Session;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Document
public class Room {
    @Id
    private String name;

    private Queue<Session> mySessions;
    private List<String> states;


    public Room(String name){
        this.name = name;
        this.mySessions = new ConcurrentLinkedQueue<>();
        this.states = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Queue<Session> getMySessions() {
        return mySessions;
    }

    public void setMySessions(Queue<Session> mySessions) {
        this.mySessions = mySessions;
    }

    public void addSession(Session session){
        mySessions.add(session);
    }

    public String deleteLastState(){
        if(states.size() > 0) {
            states.remove(states.size() - 1);
            return states.get(states.size() - 1);
        }
        return null;
    }

    public void addState(String state) {
        states.add(state);
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

}
