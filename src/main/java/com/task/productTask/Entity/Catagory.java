package com.task.productTask.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name ="Catagory")
@NoArgsConstructor
@AllArgsConstructor
public class Catagory {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "ID")
public long cid;

@Column(name = "Name")
public String cname;

@OneToMany(mappedBy = "catagory", cascade = CascadeType.ALL,orphanRemoval = true)


@JsonManagedReference
List<ProductEntity>productEntities = new ArrayList<>();



}
