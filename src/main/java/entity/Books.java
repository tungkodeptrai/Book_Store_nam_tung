/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author TNO
 */
@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Books {
    private int id;
    private String name;
    private String image;
    private int quantity;
    private String author;
    private Timestamp date_of_public;
    private int price;
    private String publisher;
    private String description;
    private int categoryId;

}
