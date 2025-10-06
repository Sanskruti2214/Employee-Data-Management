package com.example.employee;

import com.example.employee.controllers.EmployeeController;
import com.example.employee.models.Employee;
import com.example.employee.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    void testGetAllEmployees() throws Exception {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Ankita");
        e1.setEmail("ankita@gmail.com");
        e1.setPosition("Developer");
        e1.setSalary(500000);

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("John");
        e2.setEmail("john@gmail.com");
        e2.setPosition("Tester");
        e2.setSalary(400000);

        Mockito.when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(e1, e2));

        mockMvc.perform(get("/api/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Ankita"));
    }

    @Test
    void testAddEmployee() throws Exception {
        Employee saved = new Employee();
        saved.setId(1);
        saved.setName("Priya");
        saved.setEmail("priya@gmail.com");
        saved.setPosition("Designer");
        saved.setSalary(450000);

        Mockito.when(employeeService.addEmployee(any(Employee.class))).thenReturn(saved);

        String newEmployeeJson = """
            {
              "name": "Priya",
              "email": "priya@gmail.com",
              "position": "Designer",
              "salary": 450000
            }
        """;

        mockMvc.perform(post("/api/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newEmployeeJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Priya"))
                .andExpect(jsonPath("$.email").value("priya@gmail.com"));
    }

    @Test
    void testUpdateEmployee() throws Exception {
        Employee updated = new Employee();
        updated.setId(1);
        updated.setName("Amit");
        updated.setEmail("amit@gmail.com");
        updated.setPosition("Lead");
        updated.setSalary(900000);

        Mockito.when(employeeService.updateEmployee(eq(1), any(Employee.class))).thenReturn(updated);

        String updateJson = """
            {
              "name": "Amit",
              "email": "amit@gmail.com",
              "position": "Lead",
              "salary": 900000
            }
        """;

        mockMvc.perform(put("/api/employees/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.position").value("Lead"))
                .andExpect(jsonPath("$.salary").value(900000));
    }

    @Test
    void testDeleteEmployee() throws Exception {
        mockMvc.perform(delete("/api/employees/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testSearchEmployees() throws Exception {
        Employee e = new Employee();
        e.setId(1);
        e.setName("Ankita Dhelte");
        e.setEmail("ankita@gmail.com");
        e.setPosition("Developer");
        e.setSalary(550000);

        Mockito.when(employeeService.searchEmployeesByName("Ankita")).thenReturn(List.of(e));

        mockMvc.perform(get("/api/employees/search").param("name", "Ankita"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("ankita@gmail.com"));
    }
}
