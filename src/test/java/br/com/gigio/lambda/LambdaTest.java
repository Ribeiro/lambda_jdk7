package br.com.gigio.lambda;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import java.util.List;
import javax.el.ELProcessor;
import org.junit.Before;
import org.junit.Test;



public class LambdaTest {
	
	private ELProcessor elProcessor;

    @Before
    public void init() {
        this.elProcessor = new ELProcessor();
    }
	
	@SuppressWarnings("unchecked")
	@Test
    public void lambda(){
        Object result = elProcessor.eval("[1,2,3,4,5,6,7,8].stream().filter(i->i%2 == 0).map(i->i*10).toList()");
        System.out.println("Result: " + result);
        List<Object> results = (List<Object>) result; 
        assertThat(results.size(), equalTo(4));
        
        result = elProcessor.eval("[1,5,3,7,4,2,8].stream().sorted((i,j)->j-i).toList()");
        System.out.println("Result: " + result);
        results = (List<Object>) result;
        assertThat(results.size(), equalTo(7));
    }

}
