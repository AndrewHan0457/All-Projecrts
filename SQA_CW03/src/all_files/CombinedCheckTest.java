package all_files;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class CombinedCheckTest {
	
	@Test
	void test() {
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(outContent));
	    
	    String data = "e\nwoshifashi@163.com\r\n";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
    	    String[] args = null;
    	    CombinedCheck.main(args);
    	} finally {
          System.setIn(stdin);
    	}
	    
        if((data.charAt(0)+"").toLowerCase().equals("e"))
        	assertThat(outContent.toString(), containsString("Valid Email ID"));
        else if((data.charAt(0)+"").toLowerCase().equals("p"))
        	assertThat(outContent.toString(), containsString("Strong password"));
        else
        	return;
	    }

}
