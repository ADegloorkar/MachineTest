package com.task.productTask.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;

@Data
@Table(name = "Product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Column(name = "ID")


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long pId;

    @Column(name = "Name")
    public String pname;

    @Column(name = "Price")
    public Double price;

    @ManyToOne
    @JoinColumn(name="cid")
    @JsonManagedReference
    Catagory catagory;


}
