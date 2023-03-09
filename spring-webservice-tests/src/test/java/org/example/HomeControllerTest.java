package org.example;

import org.example.controller.HomeController;
import org.example.model.NewVideo;
import org.example.service.VideoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// A Spring Boot test annotation that enables Spring MVC’s machinery. The controllers parameter constrains this test suite to only the HomeController class.
@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {

  // Adds an instance of Spring’s MockMvc utility to the application context. Then, we can autowire it into our test suite for all test methods to use.
  @Autowired MockMvc mvc;

  // Using Spring Boot Test’s @MockBean annotation creates a mocked version of the required bean and adds it into the application context.
  @MockBean
  VideoService videoService;

  // invokes the base URL of the HomeController class and checks various aspects of it
  @Test
  @WithMockUser
  void indexPageHasSeveralHtmlForms() throws Exception {
    String html = mvc.perform( //
      get("/")) //
      .andExpect(status().isOk()) //
      .andExpect( //
        content().string( //
          containsString("Username: user"))) //
      .andExpect( //
        content().string( //
          containsString("Authorities: [ROLE_USER]"))) //
      .andReturn() //
      .getResponse().getContentAsString();

    assertThat(html).contains( //
      "<form action=\"/logout\"", //
      "<form action=\"/search\"", //
      "<form action=\"/new-video\"");
  }


  // Uses Mockito’s hook to verify that the create() method of the mocked VideoService bean was called with the same parameters fed by MockMVC and the username from @WithMockUser

  @Test
  @WithMockUser
  void postNewVideoShouldWork() throws Exception {
    mvc.perform( //
      post("/new-video") //
        .param("name", "new video") //
        .param("description", "new desc") //
        .with(csrf())) // supply the proper CSRF token
      .andExpect(redirectedUrl("/")); // verifies that the controller issues an HTTP redirect
    verify(videoService).create( //
      new NewVideo( //
        "new video", //
        "new desc"), //
      "user");
  }
}
