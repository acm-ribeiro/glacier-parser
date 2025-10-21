package domain;

import java.io.Serial;
import java.io.Serializable;


public class LeftTerm implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Call call;
    private boolean hasCurls;

    public LeftTerm(Call call, boolean hasCurls){
        this.call = call;
        this.hasCurls = hasCurls;
    }

    public Call getCall() {
        return call;
    }

    public Url getUrl() {
        return call.getOperation().getParameter().getRequest().getUrl();
    }

    public void setCall(Call call) {
        this.call = call;
    }

    public boolean isCall() {
        return call != null;
    }

    public boolean hasResponseBody() {
        return call != null && call.hasResponseBody();
    }

    public String getQueryParameterName() {
        return call.getQueryParameterName();
    }

    public int getPathParameterIndex() {
        return call.getPathParameterIndex();
    }

    public boolean hasPathParameter() {
       return call != null && call.hasPathParameter();
    }

    public boolean hasQueryParameter() {
        return call != null && call.hasQueryParameter();
    }

    public boolean hasThis() {
        return call != null && call.hasThis();
    }

    public boolean hasPrevious () {
        return call != null && call.isPrevious();
    }

    public OperationPrevious getOperationPrevious() {
        return call != null? call.getOperationPrevious() : null;
    }

    public boolean hasComposedParameters() {
        return call != null && call.hasComposedParameters();
    }

    public boolean hasUrlComposedParameters() {
        return call != null && call.hasUrlComposedParameters();
    }

    @Override
    public String toString() {
        return call != null? call.toString() : "";
    }
}
