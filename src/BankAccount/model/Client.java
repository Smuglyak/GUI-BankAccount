package BankAccount.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Client {
    static ArrayList<Client> clientArray = new ArrayList<>();

    public int clientId;
    public String fName;
    public String lName;
    public String idDoc;
    public String address;

    private static Client client1 = new Client(1, "Alihan", "Svoloch", "WhatDocument", "Fielding6930");

    public Client(int clientId, String fName, String lName, String idDoc, String address) {
        this.clientId = clientId;
        this.fName = fName;
        this.lName = lName;
        this.idDoc = idDoc;
        this.address = address;
    }

    public void createModifyClient(int clientId, String fName, String lName, String idDoc, String address) {
        client1.clientId = clientId;
        client1.fName = fName;
        client1.lName = lName;
        client1.idDoc = idDoc;
        client1.address = address;
    }

    /**
     * Not fully implemented, what if not found
     * 
     * @param clientId
     */
    public String removeClient(int clientId) {
        for (Client client : clientArray) {
            if (client.clientId == clientId) {
                clientArray.remove(client);
                return "Client: " + clientId + " has been removed";
            }
        }
        System.out.println("No such client!");
        return null;
    }

    public String toString() {
        return "Client ID = " + clientId + " Name = " + fName + " LastName" + lName + " Identification document "
                + idDoc + " Address " + address;
    }

    public static Client getClient(int clientId) {
        for (Client client : clientArray) {
            if (client.clientId == clientId) {
                return client;
            }
        }
        System.out.println("No such student!");
        return null;
    }
}

class SingleTonClient {
    Map<Integer, Client> clients;

    public SingleTonClient(){
        clients = new HashMap<>();
    }

    /**
     * Gets client, if not present, creates it and returns it
     * @param clientId
     * @return
     */
    public Client getClient(int clientId) {
        if (!clients.containsKey(clientId)) {
            Client newClient = new Client(clientId, null, null, null, null);
            clients.put(clientId, newClient);
        }
        return clients.get(clientId);
    }
}