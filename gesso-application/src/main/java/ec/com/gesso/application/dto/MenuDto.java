package ec.com.gesso.application.dto;

import java.util.Collection;

/**
 * Created by Roberto on 05/05/2015.
 */
public class MenuDto {
    private Integer menuId;
    private String menuName;

    private Collection<OptionDto> lstOption;

    public MenuDto(){}

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Collection<OptionDto> getLstOption() {
        return lstOption;
    }

    public void setLstOption(Collection<OptionDto> lstOption) {
        this.lstOption = lstOption;
    }
}
