package com.netsky.farmbackend.dto;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Administrators")
public class Administrator extends User{
	//Will inherit from User class
	//add specific properties of Administrator here...
}
