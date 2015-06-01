package ec.com.gesso.application.dto;

/**
 * Created by Roberto on 05/05/2015.
 */
public class OptionDto {

    private Integer optionId;
    private String optionName;
    private String optionPath;
    private String optionIcon;

    public OptionDto() {
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

	public String getOptionPath() {
		return optionPath;
	}

	public void setOptionPath(String optionPath) {
		this.optionPath = optionPath;
	}

    public String getOptionIcon() {
        return optionIcon;
    }

    public void setOptionIcon(String optionIcon) {
        this.optionIcon = optionIcon;
    }
}
