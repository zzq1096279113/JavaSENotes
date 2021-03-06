package com.zzq.entity;

import java.util.List;

/**
 * @Description 页面对象
 * @ClassName Page
 * @Author zzq
 * @Date 2021/2/27 19:53
 */
public class Page<T> {
    public static final Integer PAGE_SIZE = 5;
    private Integer pageNo;     //当前页数
    private Integer pageTotal;  //总页数
    private Integer pageSize = PAGE_SIZE;   //每个页面图书数量
    private Integer pageCount;  //图书总数量
    private List<T> items;      //当前页面的图书集合
    private String url;         //请求页面的地址

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageCount, List<T> items, String url) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.items = items;
        this.url = url;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {           //检验边界
            this.pageNo = 1;
        }else if(pageNo > pageTotal){
            this.pageNo = pageTotal;
        }else{
            this.pageNo = pageNo;
        }
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}
