
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.sql.SQLException;
import java.util.List;

/**
 * this class is used to monitor the folder which includes the Create.csv, Delete.csv, Mode.csv, ChangeState.csv 
 * once the folder's file is changed then can be monitored.
 */
public class FileMonitor {
	
	public FileMonitor() {}

	public static void main(String[] args) throws SQLException {
		
		
		Manager manager = new Manager(Simulator.getInstance());
		
		
		try {
			WatchService watchService = FileSystems.getDefault().newWatchService();
			Paths.get("./InputCommand").register(watchService,   
		        StandardWatchEventKinds.ENTRY_CREATE,  
		        StandardWatchEventKinds.ENTRY_DELETE,  
		        StandardWatchEventKinds.ENTRY_MODIFY);
			
	        while (true) {  
	            WatchKey key = watchService.take();
	            for ( WatchEvent<?> event:key.pollEvents()) { 
	        		manager.SwitchCsvObject(event.context().toString());
	            }
	            if (!key.reset()) {  
		            break;  
		        }  
		    }  
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}  	
    }
}
