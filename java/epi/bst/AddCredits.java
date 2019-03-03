package epi.bst;

import java.util.*;

public class AddCredits {

    /*
    Design a data structure that implements Insert, remove , lookup addToAll and Max credit operations efficiently [Insert, max and remove has O(log n) and addToAll and Lookup has O(1) timecomplexity

     */

    private int globalCredits = 0; //add credits which is added to all
    private NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();
    private  Map<String , Integer> clientToCredits = new HashMap<>();

    public static void main(String[] args) {
        AddCredits cred = new AddCredits();
        cred.insert("A", 10);
        cred.insert("B", 20);
        cred.insert("C", 30);
        cred.insert("D", 40);

        cred.addToAll(100);

        cred.remove("D");

        System.out.print("Max credit: "+cred.max()+" Value: "+cred.lookup(cred.max()));

        //Output: Max credit: C Value: 130

    }

    public void insert(String clientId, int credit){
        remove(clientId);

        clientToCredits.put(clientId, credit-globalCredits);//need to substract globalCredit at it is not yet been added to the current client (while retrival we add it)
        Set<String> clients =  creditToClients.get(credit-globalCredits);
        if(clients == null){
            clients = new HashSet<>();
            creditToClients.put(credit-globalCredits, clients);
        }
        clients.add(clientId);
    }

    public boolean remove(String clientId){
        Integer credit = clientToCredits.get(clientId);
        if (credit!= null){
            clientToCredits.remove(clientId);

            Set<String> clients = creditToClients.get(credit);
            if(clients!= null){

                if(clients.size() == 1){
                    creditToClients.remove(credit);//just one client was there with the given credit, remove the credit entry itself
                }else{//size  > 1
                    clients.remove(clientId); // more than one clients are there for the give credit entry, just remove the mentioned client
                }

                return true;
            }
            return false;
        }
        return false;
    }

    int lookup(String clientId){
        Integer credits =  clientToCredits.get(clientId);
        return credits == null? -1: credits+globalCredits;
    }

    void addToAll(int credits){
        globalCredits+= credits;
    }

    String max(){
        if(creditToClients.isEmpty()){
            return null;
        }
        Set<String> clients =  creditToClients.lastEntry().getValue();//get the clients againt the max credit
        if(clients.isEmpty()){
            return null;
        }

        return clients.iterator().next();///return the first client with the max credit
    }
}
