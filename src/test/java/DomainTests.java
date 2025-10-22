import java.util.ArrayList;
import java.util.List;

import glacier_domain.*;
import glacier_parser.VisitorOrientedParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DomainTests {

    @Test
    public void test_url_constructor_one_id() {
        String expected = "/resources/{resource_id}";
        String actual = new Url(expected).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void test_url_constructor_multiple_ids() {
        String expected = "/projects/{id}/repository/branches/{branch}";
        String actual = new Url(expected).toString();

        assertEquals(expected, actual);
    }

    @Test
    public void test_set_collection_url_parameter_value() {
        Formula f = getFormula("for a in response_body(GET /as) : exists b in response_body(GET /as/{a.id}/bs) :- " +
                "request_body(this){name} != {b.name}");

        QuantifiedFormula quantifiedFormula = f.getQuantifiedFormula();
        quantifiedFormula.setCollectionUrlParameterValue("id", "1");

        String expected = "for a in response_body(GET /as) : exists b in response_body(GET /as/1/bs) :- " +
                "request_body(this){name} != {b.name}";
        String actual = quantifiedFormula.toString();

        assertEquals(expected, actual);
    }


    @Test
    public void test_boolean_expression_set_string_parameter() {
        Formula f = getFormula("request_body(this){name} != {b.name}");

        BooleanExpression exp = f.getBooleanExpression();
        exp.setStringParameter("name", "resource_name");

        String expected = "request_body(this){name} != resource_name";
        String actual = exp.toString();

        assertEquals(expected, actual);
    }

    @Test
    public void test_getPreviousRequest_response() {
        Formula f = getFormula("previous(response_body(GET /resources/{resource_id})) == 2");

        String actual = f.getOperationPrevious().getHTTPRequest().toString();
        String expected = "GET /resources/{resource_id}";

        assertEquals(expected, actual);
    }

    @Test
    public void test_getPreviousRequest_request() {
        Formula f = getFormula("previous(request_body(GET /resources/{resource_id})) == 2");

        String actual = f.getOperationPrevious().getHTTPRequest().toString();
        String expected = "GET /resources/{resource_id}";

        assertEquals(expected, actual);
    }

    @Test
    public void getPrevious() {
        Formula f1 = getFormula("previous(response_body(GET /rs/{r_id})) == response_body(this)");
        Formula f2 = getFormula("response_body(this) == previous(response_body(GET /rs/{r_id}))");

        OperationPrevious prev1 = f1.getOperationPrevious();
        OperationPrevious prev2 = f2.getOperationPrevious();

        assertEquals(prev1.toString(), prev2.toString());
    }

    @Test
    public void testParserBooleanValue(){
        Formula f1 = getFormula("T");
        Formula f2 = getFormula("F");

        assertEquals("true", f1.toString());
        assertEquals("false", f2.toString());

        Formula f3 = getFormula("true");
        Formula f4 = getFormula("false");

        assertEquals("true", f3.toString());
        assertEquals("false", f4.toString());
    }

    @Test
    public void testParserMultipleParameters(){
        Formula f1 = getFormula("for e in response_body(GET /enrollments) :- response_code(GET /players/{pid}/tournaments/{e.tid}) == 404");

        Url url = f1.getQuantifiedFormula().getBooleanExpression().getClause().getComparison().getLeftUrl();
        List<String> params = url.getBlockParameters();

        List<String> values = new ArrayList<>();
        values.add("100123123");
        values.add("3");
        assertEquals(values.size(), params.size());

        for (int i = 0; i < params.size(); i++)
            url.updateBlockParameter(params.get(i), values.get(i));

        String actual = f1.toString();
        String expected = "for e in response_body(GET /enrollments) :- response_code(GET /players/100123123/tournaments/3) == 404";

        assertEquals(expected, actual);
    }

    /**
     * Parser initialisation. Returns a parsed formula.
     * @param f string to be parsed as a formula
     * @return formula object.
     */
    private static Formula getFormula(String f) {
        VisitorOrientedParser parser = new VisitorOrientedParser();
        return parser.parse(f);
    }
}
