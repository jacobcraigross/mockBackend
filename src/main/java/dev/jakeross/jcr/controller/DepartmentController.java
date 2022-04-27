package dev.jakeross.jcr.controller;
import dev.jakeross.jcr.entity.Department;
import dev.jakeross.jcr.service.DepartmentService;
import dev.jakeross.jcr.service.DepartmentServiceImplementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

// lombok policy... 1:40:29 --------------

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    // Post a Department to the DB
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("logging from inside saveDepartment POST mapping of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    // Get all Departments from the DB
    @GetMapping("/departments")
    public List <Department> fetchDepartmentList() {
        LOGGER.info("logging from inside fetchDepartmentList GET mapping of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    // Get a Department based on the ID / PK --> pass in a PATH VARIABLE {id}
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartmentById(departmentId);
        return "Success, data nuked.";
    }

    @PutMapping("departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    // Get a Department based on the name.
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}

