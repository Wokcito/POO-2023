package mappers;

import dtos.ClientDTO;
import dtos.CreateClientDTO;
import models.Client;

public class ClientMapper {
	
	public static ClientDTO clientToDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO();
		
		clientDTO.setName(client.getName());
		clientDTO.setCuit(client.getCuit());
		clientDTO.setEmail(client.getEmail());
		clientDTO.setNumberPhone(client.getNumberPhone());
		clientDTO.setId(client.getId());
		
		return clientDTO;
	}
	
	public static Client dtoToClient(CreateClientDTO clientDTO, int id) {
		return new Client(
				id,
				clientDTO.getName(),
				clientDTO.getCuit(),
				clientDTO.getEmail(),
				clientDTO.getNumberPhone()
		);
	}
}
