package BackEnd.controller;

import BackEnd.dto.EmployeeDto;
import BackEnd.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createUser(@RequestBody  EmployeeDto employeeDto){
     EmployeeDto createdUser=   employeeService.createUser(employeeDto);
     return  new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @GetMapping("getUser")
    public ResponseEntity<EmployeeDto> getUser(Long id){
      EmployeeDto employeeDto=  employeeService.getUserById(id);
      return new ResponseEntity<>(employeeDto,HttpStatus.OK);
    }
    @PutMapping("updateUser")
    public ResponseEntity<EmployeeDto> updateUser(EmployeeDto employeeDto){
      EmployeeDto updatedUser=  employeeService.updateUser(employeeDto);
      return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteMapping(Long id){
        employeeService.deleteUser(id);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.NO_CONTENT);
    }

}
