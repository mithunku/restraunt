package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data

public class customer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String fullname;
@Column(unique=true)
private String email;
private long phno;
private String gender;
private String password;
@Lob
private byte[] picture;
private int age;
private String country;

}
