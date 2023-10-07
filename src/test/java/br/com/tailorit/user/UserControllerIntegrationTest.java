package br.com.tailorit.user;

import br.com.tailorit.user.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port + "/api/users";
    }

    @Test
    public void testCreateUser() {
        UserDTO userDto = new UserDTO();
        userDto.setUsername("testUser");
        userDto.setPassword("testPassword123!");

        ResponseEntity<UserDTO> postResponse = restTemplate.postForEntity(getRootUrl(), userDto, UserDTO.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testGetAllUsers() {
        ResponseEntity<UserDTO> response = restTemplate.getForEntity(getRootUrl(), UserDTO.class);
        assertNotNull(response.getBody());
    }
}

