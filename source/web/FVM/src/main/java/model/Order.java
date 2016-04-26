package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema="fvm",name = "Orders")
@SequenceGenerator(name = "OrderSequence", sequenceName = "SQ_ID_ORDER", allocationSize = 1)

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OrderSequence")
	@Column(name = "Id_Order")
	private int id;
	
	@Column(name="Date_Open_Order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOpen;
	
	@Column(name="Date_Realized_Order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRealized;
	
	@Column(name="Date_In_Attendance_Order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateIN_ATTENDANCE;
	
	@Column(name="Date_Delivered_Order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateDELIVERED;
	
	@Column(name="State_Order")
	@Enumerated(EnumType.STRING)
	private State state;
	
	@ManyToOne
	@JoinColumn(name = "Id_User_Order")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "Id_Employee_Order")
	private User employee;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "Products_Orders")
	private List<Product> products;

}
