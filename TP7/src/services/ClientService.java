package services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import models.Client;
import dtos.ClientDTO;
import dtos.CreateClientDTO;
import exceptions.CreateClientException;
import mappers.ClientMapper;

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
	public int create(CreateClientDTO clientData) throws CreateClientException {
		
		// Validation
		List<String> messages = new ArrayList<String>();
		
		if (clientData.getName().length() < 2) {
			messages.add("El nombre debe contener más de dos caracteres");
		}
		
		if (cuitRegExp.matcher(clientData.getCuit()) == null) {
			messages.add("El cuit no es válido");
		}
		
		if (emailRegExp.matcher(clientData.getEmail()) == null) {
			messages.add("El email no es válido");
		}
		
		if (numberRegExp.matcher(clientData.getNumberPhone()) == null) {
			messages.add("El número no es válido");
		}

		if (messages.size() > 0) {
			throw new CreateClientException(messages);
		}
		
		// If all is correct
		int clientId = (int)Math.random() * (9999 - 1000 + 1) + 1000;
		
		Client client = ClientMapper.dtoToClient(clientData, clientId);
		
		clients.add(client);
		return clientId;
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
		
		return ClientMapper.clientToDTO(foundClient);
	}
}
