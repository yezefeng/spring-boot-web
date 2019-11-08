package com.test.springbootweb.controllers;

import com.test.springbootweb.dao.DepartmentDao;
import com.test.springbootweb.dao.EmployeeDao;
import com.test.springbootweb.entities.Department;
import com.test.springbootweb.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/addemployee";
    }

    @PostMapping("/emp")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp{id}")
    public String toUpdatePage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
       Collection<Department> departments = departmentDao.getDepartments();
       model.addAttribute("depts",departments);
        return "emp/addemployee";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
