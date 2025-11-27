package glacier_domain;

import java.io.Serial;
import java.io.Serializable;

public class Param implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private StringParam stringParam;

    private Integer intParam;

    private Long longParam;

    public Param(StringParam stringParam, Integer intParam, Long longParam) {
        this.stringParam = stringParam;
        this.intParam = intParam;
        this.longParam = longParam;
    }

    public Long getLongParam() {
        return longParam;
    }

    public StringParam getStringParam() {
        return stringParam;
    }

    public String getStringParameterName() {
        return stringParam != null ? stringParam.getParameterName() : null;
    }

    public boolean isStringParameter() {
        return stringParam != null;
    }

    public void setStringParam(String value) {
        stringParam.setParam(value);
        intParam = null;
    }

    public Integer getIntParam() {
        return intParam;
    }

    @Override
    public String toString() {
        if (intParam != null) {
            return String.valueOf(intParam);
        } else if (longParam != null) {
			return String.valueOf(longParam);
		} else {
			return stringParam.toString();
		}
    }
}
