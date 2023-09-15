package service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import model.Client;
import dtos.ClientDTO;
import dtos.CreateClientDTO;
import exceptions.CreateClientException;

public class ClientService {
	private List<Client> clients = new ArrayList<Client>();
	private Pattern cuitRegExp = Pattern.compile("/^(20|23|27|30|33)([0-9]{9}|-[0-9]{8}-[0-9]{1})$/g");
	private Pattern emailRegExp = Pattern.compile(" /^(([^<>()\\[\\]\\\\.,;:\\s@”]+(\\.[^<>()\\[\\]\\\\.,;:\\s@”]+)*)|(“.+”))@((\\[[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}\\.[0–9]{1,3}])|(([a-zA-Z\\-0–9]+\\.)+[a-zA-Z]{2,}))$/");
	private Pattern numberRegExp = Pattern.compile("[0-9()-]+");
	
	/**
	 * Creates a new client and returns his/her id
	 * @param dataClient
	 * @return New client's id
	 * @throws CreateClientException
	 */
	public int create(CreateClientDTO dataClient) throws CreateClientException {
		
		// Validation
		List<String> messages = new ArrayList<String>();
		
		if (dataClient.getName().length() < 2) {
			messages.add("El nombre debe contener más de dos caracteres");
		}
		
		if (cuitRegExp.matcher(dataClient.getCuit()) == null) {
			messages.add("El cuit no es válido");
		}
		
		if (emailRegExp.matcher(dataClient.getEmail()) == null) {
			messages.add("El email no es válido");
		}
		
		if (numberRegExp.matcher(dataClient.getNumberPhone()) == null) {
			messages.add("El número no es válido");
		}

		if (messages.size() > 0) {
			throw new CreateClientException(messages);
		}
		
		// If all is correct
		int clientID = (int)Math.random() * (9999 - 1000 + 1) + 1000;
		
		Client client = new Client(
				clientID,
				dataClient.getName(),
				dataClient.getCuit(),
				dataClient.getEmail(),
				dataClient.getNumberPhone()
				);
		
		clients.add(client);
		return clientID;
	}
	
	/**
	 * Returns the client with the given id if it's found
	 * @param clientID
	 * @return Client found or null
	 */
	public ClientDTO find(int id) {
		Client foundClient = null;
		
		for (Client client : this.clients) {
			if (client.getId() == id) {
				foundClient = client;
			}
		}
		
		if (foundClient == null) {
			return null;
		}
		
		ClientDTO client = new ClientDTO();
		client.setName(foundClient.getName());
		client.setCuit(foundClient.getCuit());
		client.setEmail(foundClient.getEmail());
		client.setNumberPhone(foundClient.getNumberPhone());
		client.setId(foundClient.getId());
		
		return client;
	}
}
