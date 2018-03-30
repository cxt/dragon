import com.cxt.registry.impl.ZookeeperDiscover;
import com.cxt.registry.impl.ZookeeperRegistry;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * Created by Administrator on 2018/1/23.
 */
public class ZookeeperTest {
    @Test
    public  void testRegistry(){
        ZookeeperRegistry zkRegistry = new ZookeeperRegistry("127.0.0.1:2181");
        zkRegistry.register("test","127.0.0.1:8080");

        ZookeeperDiscover zkDiscover = new ZookeeperDiscover("127.0.0.1:2181");
        zkDiscover.discover("test");
    }

    @Test
    public void testDiscover(){
        ZookeeperDiscover zkDiscover = new ZookeeperDiscover("127.0.0.1:2181");
        try {

            zkDiscover.discover("test");
        }catch (Exception e){
            LoggerFactory.getLogger(ZookeeperTest.class).error(e.getMessage(),e.getStackTrace());
        }
    }
}
