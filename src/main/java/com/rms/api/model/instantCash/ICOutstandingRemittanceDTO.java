package com.rms.api.model.instantCash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ICOutstandingRemittanceDTO {

    private Integer currentPage;
    private Integer pageSize;
    private Integer total;
    private List<ICOutstandingTransactionDTO> data;

//
//    public ICOutstandingRemittanceDTO() {
//    }
//
//    public ICOutstandingRemittanceDTO(Integer currentPage, Integer pageSize, Integer total, List<ICOutstandingTransactionDTO> data) {
//        this.currentPage = currentPage;
//        this.pageSize = pageSize;
//        this.total = total;
//        this.data = data;
//    }
//
//
//    public Integer getCurrentPage() {
//        return currentPage;
//    }
//
//    public void setCurrentPage(Integer currentPage) {
//        this.currentPage = currentPage;
//    }
//
//    public Integer getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(Integer pageSize) {
//        this.pageSize = pageSize;
//    }
//
//    public Integer getTotal() {
//        return total;
//    }
//
//    public void setTotal(Integer total) {
//        this.total = total;
//    }
//
//    public List<ICOutstandingTransactionDTO> getData() {
//        return data;
//    }
//
//    public void setData(List<ICOutstandingTransactionDTO> data) {
//        this.data = data;
//    }
}
