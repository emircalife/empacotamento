package br.com.calife.empacotamento.core.http.request;

import org.apache.commons.lang3.math.NumberUtils;

public class RequestPageableDTO {
    public RequestPageableDTO() {
    }
    public RequestPageableDTO(Integer page, Integer rpp) {
        this.page = page;
        this.rpp = rpp;
    }
    public static final Integer DEFAULT_PAGE = NumberUtils.INTEGER_ONE;
    public static final Integer DEFAULT_RPP = Integer.valueOf(10);
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getRpp() {
        return rpp;
    }
    public void setRpp(Integer rpp) {
        this.rpp = rpp;
    }
    private Integer page = DEFAULT_PAGE;
    private Integer rpp = DEFAULT_RPP;
    public int getOffset() {
        return (getPage() - 1) * getRpp();
    }
    public final int getNumberOfRows() {
        return getRpp();
    }
}