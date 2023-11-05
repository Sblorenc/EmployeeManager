package com.sblorenc.EmployeeManager.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sblorenc.EmployeeManager.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee>findById(@Param("id")Long id);
	
	void deleteById(@Param("id")Long id);
	
}
