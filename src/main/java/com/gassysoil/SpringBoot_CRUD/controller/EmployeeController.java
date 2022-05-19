package com.gassysoil.SpringBoot_CRUD.controller;

import com.gassysoil.SpringBoot_CRUD.entity.Employee;
import com.gassysoil.SpringBoot_CRUD.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/employees")
public class EmployeeController{
    private EmployeeService employeeService;

    public EmployeeController (EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String employeeList(Model model){
        List<Employee> employees = employeeService.findAllByOrderByLastNameAsc();//get employees from database
        model.addAttribute("employees", employees);
        return "employees/employee-list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employees/employee-form";
    }

    @GetMapping("showFormForUpdate")
    //matches: <a th:href="@{/employees/showFormForUpdate(employeeId=${employee.id})}"
    public String showFormForUpdate(@ModelAttribute("employeeId") int id, Model model){
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);//same as add a new one here
        return "employees/employee-form";
    }

    @PostMapping("/save")
    //matches: th:object="${employee}" method="POST"> in the employee-form
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.save(employee);

        //use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    //matches: <a th:href="@{/employees/showFormForUpdate(employeeId=${employee.id})}"
    public String showFormForDelete(@ModelAttribute("employeeId") int id){
        employeeService.deleteById(id);
        return "redirect:/employees/list";
    }
}






