/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
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

public class PageControl {
    private String urlPattern;   
    private int totalPage;
    private int totalRecord;
    private int page;

//    public PageControl() {
//    }
//
//    public PageControl(int totalPage, int totalRecord, int page) {
//        this.totalPage = totalPage;
//        this.totalRecord = totalRecord;
//        this.page = page;
//    }
//
//    public int getTotalPage() {
//        return totalPage;
//    }
//
//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }
//
//    public int getTotalRecord() {
//        return totalRecord;
//    }
//
//    public void setTotalRecord(int totalRecord) {
//        this.totalRecord = totalRecord;
//    }
//
//    public int getPage() {
//        return page;
//    }
//
//    public void setPage(int page) {
//        this.page = page;
//    }
//    
    
  
}
