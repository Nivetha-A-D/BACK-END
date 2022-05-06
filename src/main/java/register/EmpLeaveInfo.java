package register;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Employee_Leave_Info")
public class EmpLeaveInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Employee_ID")
	private int employee_id;
	@Column(name="Leave_Date")
	private String leave_date;
	@Column(name="Leave_Status")
	 private String leave_status="Pending";
//	@ManyToOne
//	private EmployeeInfo emp;
}
