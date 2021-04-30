package com.example.PersonDemo.integration;

import static org.junit.jupiter.api.Assertions.*;

import com.example.PersonDemo.models.GenericErrorResponse;
import com.example.PersonDemo.models.Person;
import com.example.PersonDemo.services.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestEndpointITest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    private PersonService personService;

    @Test
    public void testSuccessWithAllParams()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("person-age", "42");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Person> resp = testRestTemplate.exchange(
                "/rest/names/Nathan?=nickName=Nafe",
                HttpMethod.GET,
                request,
                Person.class);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals("Nathan", resp.getBody().getName());
        assertEquals("Nafe", resp.getBody().getNickName());
        assertEquals(Integer.valueOf(42), resp.getBody().getAge());
    }

    @Test
    public void testLegacySuccessWithAllParams()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("person-age", "42");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<Person> resp = testRestTemplate.exchange(
                "/legacy/names/Nathan?=nickName=Nafe",
                HttpMethod.GET,
                request,
                Person.class);
        assertEquals(HttpStatus.OK, resp.getStatusCode());
        assertEquals("Nathan", resp.getBody().getName());
        assertEquals("Nafe", resp.getBody().getNickName());
        assertEquals(Integer.valueOf(42), resp.getBody().getAge());
    }

    @Test
    public void testLegacyWithInvalidAge()
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("person-age", "Cheese burgers");
        HttpEntity request = new HttpEntity(headers);

        ResponseEntity<GenericErrorResponse> resp = testRestTemplate.exchange(
                "/legacy/names/Nathan?=nickName=Nafe",
                HttpMethod.GET,
                request,
                GenericErrorResponse.class);
        assertEquals(HttpStatus.BAD_REQUEST, resp.getStatusCode());
        assertEquals("N400", resp.getBody().getErrorCode());
        assertEquals("Invalid age supplied. Must be a valid number", resp.getBody().getErrorMessage());
    }
}
