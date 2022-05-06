package register;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee_Info")
public class EmployeeInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Employee_ID")
	private int employee_id;
	@Column(name="Employee_Name")
	private String employee_name;
	@Column(name="Employee_Type")
	private String employee_type;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
//	@OneToMany
//	private List<EmpLeaveInfo> leaves;
	
	

}
